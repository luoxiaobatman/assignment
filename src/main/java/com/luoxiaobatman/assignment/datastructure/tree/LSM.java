package com.luoxiaobatman.assignment.datastructure.tree;

/**
 * log-structured-merge tree
 * <p>
 * 用于SSTable(sorted string table)的数据结构
 * <p>
 * 多用于nosql, 数仓场景
 *
 * 写入快于Btree或其变种, 读慢. 不产生磁盘碎片, 事务支持稍差
 * 监控merge慢于write的情况
 */
public class LSM {
}
