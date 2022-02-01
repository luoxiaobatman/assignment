package com.luoxiaobatman.assignment.datastructure.tree.binarytree;

import com.luoxiaobatman.assignment.datastructure.support.AbstractNode;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.Node;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;

/**
 * node binary tree的节点
 * parent sibling? leftChild rightChild
 */
public class TreeNode extends AbstractNode implements Node {
    private Identifier parent;
    private Identifier leftChild;
    private Identifier rightChild;

    protected TreeNode(Identifier identifier) {
        super(identifier);
    }

    public Identifier getParent() {
        return parent;
    }

    public void setParent(Identifier parent) {
        this.parent = parent;
    }

    public Identifier getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Identifier leftChild) {
        this.disconnect(this.leftChild);
        this.connect(leftChild);
        this.leftChild = leftChild;
    }

    public Identifier getRightChild() {
        return rightChild;
    }

    public void setRightChild(Identifier rightChild) {
        this.disconnect(this.rightChild);
        this.connect(rightChild);
        this.rightChild = rightChild;
    }
}
