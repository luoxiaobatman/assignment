package com.luoxiaobatman.assignment.interview.coding.huawei;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * dp[s][t] 二维数组
 * s: n
 * t: 前面有t个前括号
 * dp[n][1]: 解
 * 定义: dp[n][1] = dp[n][0]
 * <p>
 * ()  -> dp[n-1][1]
 * ((  -> dp[n][2]
 * (() -> dp[n-1][1]
 * ((( -> dp[n][3]
 * ((() -> dp[n-1][2]
 * (((( -> dp[n][4]
 * ...
 * ()  -> 打印 n-1 然后字符串左侧append: ()
 * ((  -> dp[n][2]
 * (() -> 打印 n-1 然后字符串的第一个左括号后面append: ()
 * ((( -> dp[n][3]
 * ((() -> 打印 n-2
 * (((( -> dp[n][4]
 * ...
 * <p>
 * dp[n][1] = dp[n-1][0] + dp[n][2]
 * dp[n][2] = dp[n-1][1] + dp[n][3]
 * dp[n][3] = dp[n-1][2] + dp[n][4]
 * dp[n][4] = dp[n-1][3] + dp[n][5]
 * <p>
 * 初始条件:
 * dp[1][1] = 1
 * dp[1][0] = dp[1][1]
 * <p>
 * dp[2][1] = dp[1][0] + dp[2][2] = 2
 * dp[2][2] = dp[1][1] + 0 = 1
 * <p>
 * dp[3][1] = dp[2][0] + dp[3][2] = 5
 * dp[3][2] = dp[2][1] + dp[3][3] = 3
 * dp[3][3] = dp[2][2] + 0 = 1
 * <p>
 * <p>
 * ===================================
 * 打印:
 * ( 1
 * (   ) 2
 * (  ) (  ) 3
 * (
 * (
 * (
 * (
 * ( xxx
 */
@AllArgsConstructor
public class P22 extends AbstractSolution<List<String>> implements GenericSolution<List<String>> {
    private final int numberOfParenthesis;
    private List<String> result;

    @Override
    public List<String> doSolve() {
        result = new ArrayList<>();
        NodeInfo root = new NodeInfo();
        traverse(root);
        return result;
    }

    private void traverse(NodeInfo parent) {
        if (isValidParenthesis()) {
            NodeInfo leftChild = new NodeInfo(parent, true);
            traverse(leftChild);

            NodeInfo rightChild = new NodeInfo(parent, false);
            if (rightChild.rightParenthesisCount == numberOfParenthesis) {
                result.add(rightChild.parenthesis);
            } else {
                traverse(rightChild);
            }
        }
    }

    private boolean isValidParenthesis() {
        return true;
    }

    private static class NodeInfo {
        public NodeInfo(NodeInfo parent, boolean isLeftChild) {

        }

        public NodeInfo() {
            leftParenthesisCount = 1;
            parenthesis = "(";
        }

        int leftParenthesisCount = 0;
        int rightParenthesisCount = 0;
        String parenthesis;
    }
}
