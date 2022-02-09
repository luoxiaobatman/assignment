package com.luoxiaobatman.assignment.datastructure.tree.binarytree;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;

public class BinarySearchTree extends NodeBinaryTree implements SearchTree {
    public BinarySearchTree(Identifier root) {
        super(root);
    }

    public BinarySearchTree(NodeBinaryTree nodeBinaryTree) {
        super(nodeBinaryTree.getRoot());
        this.nodes = nodeBinaryTree.nodes;
    }

    @Override
    public Identifier min() {
        Identifier parent = getRoot();
        Identifier child = leftChild(parent);
        while (child != null) {
            parent = child;
            child = leftChild(parent);
        }
        return parent;
    }

    @Override
    public Identifier max() {
        Identifier parent = getRoot();
        Identifier child = rightChild(parent);
        while (child != null) {
            parent = child;
            child = rightChild(parent);
        }
        return parent;
    }

    /**
     * TODO luoxiao 实现二叉搜索树的添加节点算法
     * @param identifier 节点标识, 注意重复节点的问题
     */
    @Override
    public void add(Identifier identifier) {
        if (!nodes.containsKey(identifier)) {

        }
    }

    /**
     * TODO luoxiao 实现二叉搜索树的删除节点算法
     * @param identifier 节点标识
     */
    @Override
    public void remove(Identifier identifier) {
        if (nodes.containsKey(identifier)) {

        }
    }
}
