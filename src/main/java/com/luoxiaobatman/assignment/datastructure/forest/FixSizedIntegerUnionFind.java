package com.luoxiaobatman.assignment.datastructure.forest;

import lombok.AllArgsConstructor;

/**
 * 固定大小, 数组实现, 元素仅包括数字
 * <p>
 * 并查集
 */
@AllArgsConstructor
public class FixSizedIntegerUnionFind implements UnionFind {

    private final int[] array;



    @Override
    public int find(int i) {
        return 0;
    }

    @Override
    public void union(int i, int j) {

    }
}
