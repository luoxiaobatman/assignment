package com.luoxiaobatman.assignment.datastructure.tree;

public interface UF {
    int find(int n);
    void union(int a, int b);
    int count();
}
