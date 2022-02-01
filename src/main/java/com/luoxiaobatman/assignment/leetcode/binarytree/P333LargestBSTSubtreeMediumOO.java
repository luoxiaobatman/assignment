package com.luoxiaobatman.assignment.leetcode.binarytree;

import com.luoxiaobatman.assignment.datastructure.support.AbstractIdentifier;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.IntegerIdentifier;
import com.luoxiaobatman.assignment.datastructure.tree.binarytree.BinaryTree;
import com.luoxiaobatman.assignment.datastructure.tree.binarytree.MaxBinarySearchTree;
import com.luoxiaobatman.assignment.datastructure.tree.binarytree.NodeBinaryTree;
import com.luoxiaobatman.assignment.datastructure.tree.binarytree.SearchTree;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.support.solution.Solver;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * object oriented
 * <p>
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
 * <p>
 * 二叉搜索树（BST）中的所有节点都具备以下属性：
 * <p>
 * 左子树的值小于其父（根）节点的值。
 * <p>
 * 右子树的值大于其父（根）节点的值。
 * <p>
 * 注意：子树必须包含其所有后代。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 10 5 15 1 8 null 7
 * <p>
 * 输入：root = [10,5,15,1,8,null,7]
 * 输出：3
 * 解释：本例中最大的 BST 子树是高亮显示的子树。返回值是子树的大小，即 3 。
 * 示例 2：
 * <p>
 * 输入：root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 树上节点数目的范围是 [0, 104]
 * -104 <= Node.val <= 104
 *  
 * <p>
 * 进阶:  你能想出 O(n) 时间复杂度的解法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-bst-subtree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@AllArgsConstructor
public class P333LargestBSTSubtreeMediumOO
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {

    private final Integer[] fullBinaryTreeArray;

    @Override
    public Integer doSolve() {
        if (fullBinaryTreeArray == null || fullBinaryTreeArray.length == 0) return 0;

        Identifier[] identifiers = Arrays.stream(fullBinaryTreeArray)
                .map(i -> {
                    if (i == null) return null;
                    return new MyIdentifier(i);
                }).toArray(Identifier[]::new);
        BinaryTree binaryTree = NodeBinaryTree.of(identifiers);
        SearchTree searchTree = Solver.solve(MaxBinarySearchTree.class, binaryTree);
        return searchTree.size();
    }

    /**
     * randomUUID
     */
    private static class MyIdentifier extends AbstractIdentifier implements Identifier {
        private final String id;

        private MyIdentifier(Integer val) {
            this.id = UUID.randomUUID().toString();
            this.mark(val);
        }

        @Override
        public int compareTo(@NotNull Identifier identifier) {
            return (Integer) this.mark() - (Integer) identifier.mark();
        }


        @Override
        public String id() {
            return id;
        }

        @Override
        public String toString() {
            return mark().toString();
        }
    }
}
