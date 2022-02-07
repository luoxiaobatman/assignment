package com.luoxiaobatman.assignment.datastructure.graph;

/**
 * TODO luoxiao 代码实现
 * <p>
 * 最短路径, 支持环, 不支持负weight
 * <p>
 * 数组, 下标是identifier, 值是最短路径+标记
 * <p>
 * 初始化数组, 起始下标0, 值0+标记未扫描, 其他无穷大+标记未扫描
 * <pre>
 * for 数组中标记未扫描的最小值的下标
 *    for edges
 *       如果值 + weight < 值, 更新值
 *    标记下标已扫描
 * </pre>
 * 得到的数组就是dijkstra算法解出来的从初始点到图中所有点的最短路径
 */
public class Dijkstra {
}
