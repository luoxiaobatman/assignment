package com.luoxiaobatman.assignment.datastructure.tree.binarytree;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;

public interface SearchTree extends BinaryTree {
    /**
     * @return 树所有节点的最小元素
     */
    Identifier min();

    /**
     * @return 树所有节点的最大元素
     */
    Identifier max();

    // 从数组中构建二叉搜索树
    static SearchTree of(Identifier... identifiers) {
        return null;
    }
}
