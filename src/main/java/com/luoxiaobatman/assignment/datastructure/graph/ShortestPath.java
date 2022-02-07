package com.luoxiaobatman.assignment.datastructure.graph;

import com.luoxiaobatman.assignment.datastructure.graph.adjacentlist.DirectedGraph;
import com.luoxiaobatman.assignment.datastructure.support.Node;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 有向图最短路径算法, 通用
 * <p>
 * 有向图带权重, 有最大步数限制, 没有权重为负的边
 * <p>
 * 返回最短路径的节点标识
 * <p>
 * 如果shortestpath不存在
 */
public class ShortestPath extends GraphVisitor<List<Identifier>> {
    static private final Integer MARK_PERMANENT = 1;
    static private final Integer MARK_TEMPORARY = 2;
    private List<Identifier> sorted;


    /**
     * @param g       有向图
     * @param start   起点
     * @param end     终点
     */
    public ShortestPath(Graph g, Identifier start, Identifier end) {
        super(g);
    }

    @Override
    public List<Identifier> doSolve() {
        try {
            visit(graph);
        } catch (NoPathFound e) {
            return null;
        }
        return sorted;
    }

    @Override
    protected void visit(Graph graph) throws NoPathFound {
        sorted = new ArrayList<>();
    }


    /**
     * node 有两个标识, permanent, temporary
     * 再次访问temporary, 表示图中出现了cyclic
     * 略过再次访问permanent
     *
     * @param graph      有向图
     * @param identifier 节点标识
     * @throws NoPathFound visit identifier 有 temporary标记
     */
    private void shortestPath(Graph graph, Identifier start, Identifier end) throws NoPathFound {

    }

    /**
     *
     */
    private static class NoPathFound extends RuntimeException {
    }
}
