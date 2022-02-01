package com.luoxiaobatman.assignment.datastructure.tree.binarytree;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;

public class BinarySearchTree extends NodeBinaryTree implements SearchTree{
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
}
