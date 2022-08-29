package com.luoxiaobatman.assignment.interview.coding.strikingly.parser;

import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.Token;
import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.TokenLiteral;
import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.TokenPrefixSuffix;
import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.TokenRoot;

import java.util.*;

public class DoubleCurlyBracesParser implements Parser {
    static private final String PREFIX = "{{";
    static private final String SUFFIX = "}}";

    private static final int TOKEN_PREFIX = 1;
    private static final int TOKEN_SUFFIX = 2;


    @Override
    public Token tokenize(String template) {
        if (template == null) return null;
        int[] hits = prepareTokenizePrefixAndSuffix(template);
        List<TokenPrefixSuffix> flatTokens = tokenizePrefixAndSuffix(hits);
        return structureTokens(template, flatTokens);
    }


    /**
     * scan template, find interesting points, tag them using an array
     */
    private int[] prepareTokenizePrefixAndSuffix(String template) {
        int l = template.length();
        int[] tokens = new int[l];
        for (int i = 0; i < l - 1; i++) {
            if (SUFFIX.equals(template.substring(i, i + 2))) {
                tokens[i] = TOKEN_SUFFIX;
                i++;
            }
        }
        for (int i = l - 2; i > 0; i--) {
            if (PREFIX.equals(template.substring(i, i + 2))) {
                tokens[i] = TOKEN_PREFIX;
                i--;
            }
        }
        return tokens;
    }

    /**
     * build trivial token (unstructured)
     */
    private List<TokenPrefixSuffix> tokenizePrefixAndSuffix(int[] hits) {
        Deque<Integer> prefixIndexes = new ArrayDeque<>();
        List<TokenPrefixSuffix> unStructuredTokens = new ArrayList<>();
        int suffixIndex = -1;
        for (int index = 0; index < hits.length; index++) {
            if (hits[index] == TOKEN_PREFIX) {
                prefixIndexes.push(index);
            } else if (hits[index] == TOKEN_SUFFIX) {
                try {
                    int prefixIndex = prefixIndexes.pop();
                    suffixIndex = index;
                    unStructuredTokens.add(new TokenPrefixSuffix(prefixIndex, suffixIndex));
                } catch (NoSuchElementException ignored) {
                }
            }
        }

        return unStructuredTokens;
    }

    /**
     * @param template ...
     * @param flatTokens precompiled token, unstructured
     * @return the root of tokens, act as an entry point for the AST tree if you prefer fancy word...
     */
    private Token structureTokens(String template, List<TokenPrefixSuffix> flatTokens) {
        Deque<Integer> suffixIndexStack = new ArrayDeque<>();
        Map<Integer, Token> suffixTokenMap = new HashMap<>();
        TokenRoot root = new TokenRoot();
        int literalStartIndex = 0;

        // TODO below is for dealing with recursive curly braces like {{ {{ }} {{ {{ }} }} }}
        // its incomplete sadly
        s:
        for (TokenPrefixSuffix tokenPS : flatTokens) {
            suffixTokenMap.put(tokenPS.suffixIndex, tokenPS);
            if (tokenPS.prefixIndex > literalStartIndex) {
                root.getChildren().add(new TokenLiteral(template.substring(literalStartIndex, tokenPS.prefixIndex)));
                literalStartIndex = tokenPS.suffixIndex + SUFFIX.length();
            }
            Integer pop;
            try {
                while ((pop = suffixIndexStack.pop()) != null) {
                    if (pop > tokenPS.suffixIndex) {
                        suffixTokenMap.get(pop).getChildren().add(tokenPS);
                        suffixIndexStack.push(tokenPS.suffixIndex);
                        suffixIndexStack.push(pop);
                        continue s;
                    }
                }
            } catch (NoSuchElementException ignored) {
                suffixIndexStack.push(tokenPS.suffixIndex);
                root.getChildren().add(tokenPS);
            }
        }
        if (!flatTokens.isEmpty()) {
            TokenPrefixSuffix lastOne = flatTokens.get(flatTokens.size() - 1);
            if (lastOne.suffixIndex < template.length() - SUFFIX.length()) {
                root.getChildren().add(
                        new TokenLiteral(template.substring(lastOne.suffixIndex + SUFFIX.length()))
                );
            }
        }
        return root;
    }
}
