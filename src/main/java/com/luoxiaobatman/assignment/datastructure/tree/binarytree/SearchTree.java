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

    /**
     * 添加节点
     *
     * @param identifier 节点标识, 注意重复节点的问题
     */
    void add(Identifier identifier);

    /**
     * 删除标识对应的节点, 一个标识只能对应一个节点
     *
     * @param identifier 标识
     */
    void remove(Identifier identifier);

    // 从数组中构建二叉搜索树
    static SearchTree of(Identifier... identifiers) {
        return null;
    }
}
