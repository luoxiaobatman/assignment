package com.luoxiaobatman.assignment.datastructure.tree.binarytree;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.support.solution.Solver;

/**
 * 最大二叉搜索树 子树算法
 * <p>
 * 最大是指拥有的节点最多, 如果有重复, 返回找到的第一个
 */
public class MaxBinarySearchTree extends BinaryTreeVisitor<SearchTree> {
    private SearchTree maxSizeBinarySearchTree;

    public MaxBinarySearchTree(BinaryTree binaryTree) {
        super(binaryTree);
    }

    @Override
    public SearchTree doSolve() {
        visit(binaryTree);
        return maxSizeBinarySearchTree;
    }

    @Override
    protected void visit(BinaryTree binaryTree) {
        maxSizeBinarySearchTree = null;

        Identifier root = binaryTree.getRoot();
        Identifier left = binaryTree.leftChild(root);
        Identifier maxLeft = left;
        Identifier right = binaryTree.rightChild(root);
        Identifier minRight = right;
        SearchTree leftMaxSizeBinarySearchTree = null;
        SearchTree rightMaxSizeBinarySearchTree = null;
        if (left != null) {
            leftMaxSizeBinarySearchTree = Solver.solve(MaxBinarySearchTree.class, binaryTree.subTree(left));
            maxLeft = leftMaxSizeBinarySearchTree.max();
        }
        if (right != null) {
            rightMaxSizeBinarySearchTree = Solver.solve(MaxBinarySearchTree.class, binaryTree.subTree(right));
            minRight = rightMaxSizeBinarySearchTree.min();
        }
        boolean isThisSearchTree = true;
        if (left != null) {
            isThisSearchTree = isThisSearchTree && left.equals(leftMaxSizeBinarySearchTree.getRoot());
            isThisSearchTree = isThisSearchTree && root.compareTo(maxLeft) > 0;
        }
        if (right != null) {
            isThisSearchTree = isThisSearchTree && right.equals(rightMaxSizeBinarySearchTree.getRoot());
            isThisSearchTree = isThisSearchTree && root.compareTo(minRight) < 0;
        }

        if (isThisSearchTree) {
            maxSizeBinarySearchTree = new BinarySearchTree((NodeBinaryTree) binaryTree);
        } else {
            int leftSize = Integer.MIN_VALUE;
            int rightSize = Integer.MIN_VALUE;
            if (leftMaxSizeBinarySearchTree != null) {
                leftSize = leftMaxSizeBinarySearchTree.size();
            }
            if (rightMaxSizeBinarySearchTree != null) {
                rightSize = rightMaxSizeBinarySearchTree.size();
            }
            if (leftSize >= rightSize) {
                maxSizeBinarySearchTree = leftMaxSizeBinarySearchTree;
            } else {
                maxSizeBinarySearchTree = rightMaxSizeBinarySearchTree;
            }
        }
    }
}
