package com.luoxiaobatman.assignment.datastructure.tree;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.tree.binarytree.BinarySearchTree;
import com.luoxiaobatman.assignment.datastructure.tree.binarytree.BinaryTree;
import com.luoxiaobatman.assignment.datastructure.tree.binarytree.NodeBinaryTree;
import com.luoxiaobatman.assignment.datastructure.tree.binarytree.SearchTree;

/**
 * 自平衡二叉树
 * <p>
 * 面试写不出来, 面试写不出来就写不出来吧
 * <p>
 * 能手写自平衡算法就行
 */
public class AVLTree extends BinarySearchTree implements BinaryTree, SearchTree {
    public AVLTree(NodeBinaryTree nodeBinaryTree) {
        super(nodeBinaryTree);
    }

    public AVLTree(Identifier root) {
        super(root);
    }

    // 重写 add remove
    // 加入自平衡策略 LL LR RL RR
    // 不允许connect相关方法

    @Override
    public void add(Identifier identifier) {
        super.add(identifier);
    }

    @Override
    public void remove(Identifier identifier) {
        super.remove(identifier);
    }
}
