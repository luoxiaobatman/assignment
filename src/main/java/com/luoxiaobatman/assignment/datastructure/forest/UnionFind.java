package com.luoxiaobatman.assignment.datastructure.forest;

/**
 * 并查集
 *
 * 在学习最小生成树的 K 算法的时候用到,
 */
public interface UnionFind {
    /**
     * @param i
     * @return i的根节点
     */
    int find(int i);

    /**
     * 找到i和j的根节点,
     * 将其中一个根节点的父亲设置成i(j)
     */
    void union(int i, int j);
}
