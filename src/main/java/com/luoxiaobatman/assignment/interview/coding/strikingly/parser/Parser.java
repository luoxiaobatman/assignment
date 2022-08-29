package com.luoxiaobatman.assignment.interview.coding.strikingly.parser;

import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.Token;
import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.TokenLiteral;
import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.TokenPrefixSuffix;
import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.TokenRoot;

import java.util.Map;

public interface Parser {
    Token tokenize(String template) throws ParseException;

    /**
     *
     * @param token
     * @param template
     * @param values
     * @return
     * @throws ParseException
     */
    default String interpolate(Token token, String template, Map<String, Object> values) throws ParseException {
        if (token instanceof TokenLiteral) {
            return ((TokenLiteral) token).literal;
        } else if (token instanceof TokenRoot) {
            StringBuilder result = new StringBuilder();
            for (Token cToken: token.getChildren()) {
                result.append(interpolate(cToken, template, values));
            }
            return result.toString();
        } else if (token instanceof TokenPrefixSuffix) {
            // TODO 处理token嵌套的情况 譬如嵌套解析  {{ user.{{ meta-navigator }} }}
            String sTemplate = template.substring(
                    ((TokenPrefixSuffix) token).prefixIndex + 2, ((TokenPrefixSuffix) token).suffixIndex);
            return interpolate(sTemplate, values);
        } else {
            throw new ParseException();
        }
    };

    private String interpolate(String sTemplate, Map<String, Object> values) throws ParseException {
        try {
            int keySplitterIndex = sTemplate.indexOf('.');
            if (keySplitterIndex < 0) return values.get(sTemplate.trim()).toString();
            return interpolate(
                sTemplate.substring(keySplitterIndex + 1),
                    (Map<String, Object>) values.get(sTemplate.substring(0, keySplitterIndex))
            );
        } catch (Exception ignored) {
            throw  new ParseException();
        }
    }
}
