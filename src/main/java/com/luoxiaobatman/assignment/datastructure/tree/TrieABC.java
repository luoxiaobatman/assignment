package com.luoxiaobatman.assignment.datastructure.tree;


import java.util.HashSet;
import java.util.Set;

/**
 * 前缀树
 * word仅由26个英文字母
 *
 * @see com.luoxiaobatman.assignment.leetcode.greedy.P528WordsAbbreviationHardTrie
 */
public class TrieABC {
    public static final char ROOT_CHAR = '0';
    private final Set<NodeABC> wholeWordNodes = new HashSet<>();

    public static final boolean isRoot(NodeABC node) {
        return node.getCharacter() == ROOT_CHAR;
    }

    NodeABC root = new NodeABC(ROOT_CHAR, null);

    public Set<NodeABC> getWholeWordNodes() {
        return wholeWordNodes;
    }

    /**
     * @param aToZ a-z strings
     */
    public void add(String aToZ) {
        wholeWordNodes.add(root.add(aToZ));
    }
}
