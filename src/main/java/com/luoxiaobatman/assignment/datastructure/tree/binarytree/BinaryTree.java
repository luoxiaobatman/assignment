package com.luoxiaobatman.assignment.datastructure.tree.binarytree;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.tree.Tree;

/**
 * 练习种二叉树
 */
public interface BinaryTree extends Tree {
    /**
     * 左连接
     * @param parent 父标识, if null or not exists, noop. 父节点的左孩被replace
     * @param leftChild 左标识, null or ancestor of parent noop, 其他情况, 斩断左孩的父连接, 移到parent的左孩上
     */
    void leftConnect(Identifier parent, Identifier leftChild);

    /**
     * 同左连接, 当且仅当parent的左孩为空时
     */
    void leftConnectIfAbsent(Identifier parent, Identifier leftChild);
    void rightConnect(Identifier parent, Identifier rightChild);
    void rightConnectIfAbsent(Identifier parent, Identifier rightChild);

    /**
     * 返回左孩
     * @return 有左孩返回左孩, 其他情况返回空
     */
    Identifier leftChild(Identifier parent);
    Identifier rightChild(Identifier parent);

}
