package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.datastructure.graph.AStarShortestPath;
import com.luoxiaobatman.assignment.datastructure.graph.Graph;
import com.luoxiaobatman.assignment.datastructure.graph.adjacentlist.DirectedGraph;
import com.luoxiaobatman.assignment.datastructure.support.Edge;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.IntegerIdentifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.support.solution.Solver;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * 有向图, AStar
 * <p>
 * TODO luoxiao 提交到leetcode验证
 * <p>
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@AllArgsConstructor
public class P787FindCheapestPriceMediumFA
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int n;
    private final int[][] flights;
    private final int src;
    private final int dst;
    private final int k;

    @Override
    public Integer doSolve() {
        return findCheapestPrice(n, flights, src, dst, k);
    }

    // ============== leetcode ==============
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Graph graph = new DirectedGraph();
        for (int[] flight : flights) {
            Identifier start = new IntegerIdentifier(flight[0]);
            Identifier end = new IntegerIdentifier(flight[1]);
            int weight = flight[2];
            graph.connect(OrderedPair.of(start, end), weight);
        }
        Identifier start = new IntegerIdentifier(src);
        Identifier end = new IntegerIdentifier(dst);

        List<Edge> shortestPath = Solver.solve(AStarShortestPath.class, graph, start, end, k);
        int result = 0;
        if (shortestPath != null) {
            for (Edge edge : shortestPath) {
                result += edge.getWeight();
            }
        }
        return result;
    }
}
