package com.luoxiaobatman.assignment.datastructure.tree;

/**
 * @see com.luoxiaobatman.assignment.leetcode.greedy.P528WordsAbbreviationHardTrie
 */
public class NodeABC {
    /**
     * 由子节点共享的前缀
     */
    private final NodeABC parent;

    public NodeABC getParent() {
        return parent;
    }

    /**
     * 节点上的单词数量
     */
    private int wholeWordCount;
    /**
     * 经过该节点的单词数量
     */
    private int fragmentWordCount;

    public int getFragmentWordCount() {
        return fragmentWordCount;
    }
    public int getWholeWordCount() {
        return wholeWordCount;
    }

    NodeABC(char c, NodeABC parent) {
        character = c;
        children = new NodeABC[26];
        this.parent = parent;
    }

    char character;
    public char getCharacter() {
        return character;
    }

    NodeABC[] children;

    public NodeABC add(String s) {
        this.fragmentWordCount++;
        char nextPrefix = s.charAt(0);
        int index = nextPrefix - 'a';
        if (children[index] == null) {
            children[index] = new NodeABC(nextPrefix, this);
        }
        NodeABC nextHop = children[index];

        if (s.length() == 1) {
            nextHop.wholeWordCount++;
            return nextHop;
        } else {
            return nextHop.add(s.substring(1));
        }
    }

    public String prefix() {
        if (parent == null) return "";
        String prefixPlusSelf = prefixPlusSelf();
        return prefixPlusSelf.substring(0, prefixPlusSelf.length() - 1);
    }

    private String prefixPlusSelf() {
        if (parent == null) return "";
        return parent.prefixPlusSelf() + this.character;
    }

    public String word() {
        if (wholeWordCount == 0) {
            // unexpected
            throw new RuntimeException();
        } else {
            return prefixPlusSelf();
        }
    }
}