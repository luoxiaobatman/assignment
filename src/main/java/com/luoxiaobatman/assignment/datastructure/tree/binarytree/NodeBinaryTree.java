package com.luoxiaobatman.assignment.datastructure.tree.binarytree;


import com.luoxiaobatman.assignment.datastructure.stack.ArrayStack;
import com.luoxiaobatman.assignment.datastructure.stack.Stack;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.tree.Tree;
import com.luoxiaobatman.assignment.designpattern.behavior.vistor.Visitor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 节点实现的二叉树
 */
public class NodeBinaryTree implements Tree, BinaryTree {
    protected Map<Identifier, TreeNode> nodes;
    private final Identifier root;

    public static BinaryTree of(Identifier... identifiers) {
        Identifier root = identifiers[0];
        NodeBinaryTree binaryTree = new NodeBinaryTree(root);
        addChild(binaryTree, identifiers, 0);
        return binaryTree;
    }

    private static void addChild(BinaryTree binaryTree, Identifier[] identifiers, int i) {
        int leftChildIndex = i * 2 + 1;
        int rightChildIndex = i * 2 + 2;
        if (leftChildIndex < identifiers.length) {
            Identifier leftIdentifier = identifiers[leftChildIndex];
            if (leftIdentifier != null) {
                binaryTree.leftConnect(identifiers[i], identifiers[leftChildIndex]);
                addChild(binaryTree, identifiers, leftChildIndex);
            }
        }
        if (rightChildIndex < identifiers.length) {
            Identifier leftIdentifier = identifiers[rightChildIndex];
            if (leftIdentifier != null) {
                binaryTree.rightConnect(identifiers[i], identifiers[rightChildIndex]);
                addChild(binaryTree, identifiers, rightChildIndex);
            }
        }
    }

    public NodeBinaryTree(Identifier root) {
        this.root = root;
        nodes = new HashMap<>();
        nodes.put(root, new TreeNode(root));
    }

    private NodeBinaryTree(TreeNode root) {
        this.root = root.getIdentifier();
        nodes = new HashMap<>();
        nodes.put(this.root, root);
    }

    @Override
    public boolean exists(Identifier identifier) {
        return nodes.containsKey(identifier);
    }

    @Override
    public int size() {
        return nodes.size();
    }

    @Override
    public Identifier getRoot() {
        return root;
    }

    @Override
    public Tree subTree(Identifier identifier) {
        if (!nodes.containsKey(identifier)) {
            return null;
        }
        TreeNode treeNode = nodes.get(identifier);
        TreeNode root = new TreeNode(identifier);
        root.setLeftChild(treeNode.getLeftChild());
        root.setRightChild(treeNode.getRightChild());
        NodeBinaryTree subTree = new NodeBinaryTree(root);

        Stack<Identifier> stack = new ArrayStack<>();
        stack.push(root.getLeftChild());
        stack.push(root.getRightChild());
        while (stack.size() != 0) {
            Identifier next = stack.pop();
            if (next == null) continue;
            TreeNode nextNode = nodes.get(next);
            subTree.nodes.put(next, nextNode);
            stack.push(nextNode.getLeftChild());
            stack.push(nextNode.getRightChild());
        }
        return subTree;
    }

    @Override
    public void leftConnect(Identifier parent, Identifier leftChild) {
        connect(parent, leftChild, DIRECTION_LEFT, false);
    }

    @Override
    public void leftConnectIfAbsent(Identifier parent, Identifier leftChild) {
        connect(parent, leftChild, DIRECTION_LEFT, true);
    }

    @Override
    public void rightConnect(Identifier parent, Identifier rightChild) {
        connect(parent, rightChild, DIRECTION_RIGHT, false);
    }

    @Override
    public void rightConnectIfAbsent(Identifier parent, Identifier rightChild) {
        connect(parent, rightChild, DIRECTION_RIGHT, true);
    }

    @Override
    public Identifier leftChild(Identifier parent) {
        TreeNode parentNode = nodes.get(parent);
        if (parentNode != null) {
            return parentNode.getLeftChild();
        }
        return null;
    }

    @Override
    public Identifier rightChild(Identifier parent) {
        TreeNode parentNode = nodes.get(parent);
        if (parentNode != null) {
            return parentNode.getRightChild();
        }
        return null;
    }

    @Override
    public void cut(Identifier identifier) {
        if (root.equals(identifier)) {
            // TODO exception root can't be removed
            throw new RuntimeException();
        }
        TreeNode removedNode = nodes.remove(identifier);
        if (removedNode != null) {
            TreeNode parentNode = nodes.get(removedNode.getParent());
            if (identifier.equals(parentNode.getLeftChild())) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
        }
    }

    /**
     * 算法
     */
    @Override
    public void accept(Visitor visitor) {
        if (visitor instanceof BinaryTreeVisitor) {
            ((BinaryTreeVisitor<?>) visitor).visit(this);
        }
    }

    // =============================================

    private static final int DIRECTION_LEFT = 0;
    private static final int DIRECTION_RIGHT = 1;

    private void connect(Identifier parent, Identifier child, int DIRECTION, boolean absent) {
        if (parent == null) return;
        if (!nodes.containsKey(parent)) return;
        if (absent) {
            TreeNode treeNode = nodes.get(parent);
            if (DIRECTION == DIRECTION_LEFT) {
                if (treeNode.getLeftChild() != null) return;
            } else {
                if (treeNode.getRightChild() != null) return;
            }
        }

        if (nodes.containsKey(child)) {
            Identifier ancestor = parent;
            while (ancestor != null) {
                if (ancestor.equals(child)) return;
                ancestor = nodes.get(ancestor).getParent();
            }
        } else {
            TreeNode newTreeNode = new TreeNode(child);
            newTreeNode.setParent(parent);
            nodes.put(child, newTreeNode);
        }

        TreeNode parentTreeNode = nodes.get(parent);
        if (DIRECTION == DIRECTION_LEFT) {
            parentTreeNode.setLeftChild(child);
        } else {
            parentTreeNode.setRightChild(child);
        }
    }
}
