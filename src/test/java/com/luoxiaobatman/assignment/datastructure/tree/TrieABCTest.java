package com.luoxiaobatman.assignment.datastructure.tree;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.StringsArgumentsParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Set;

class TrieABCTest {
    private TrieABC trie;

    @BeforeEach
    void setup() {
        trie = new TrieABC();
    }


    @ParameterizedTest
    @SolutionSource(
            value = {
                    "abc", "abc"
            }, argumentParser = StringsArgumentsParser.class, argumentsCount = 2, delimiter = ","
    )
    void testTrieABC(String[] words, String[] expects) {
        for (String word: words) {
            trie.add(word);
        }
        Set<NodeABC> allWordNodes = trie.getWholeWordNodes();


    }
}
