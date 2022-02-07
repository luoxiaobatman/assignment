package com.luoxiaobatman.assignment.datastructure.graph;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;

import java.util.List;

/**
 * 最短路径的 bellmanford 算法
 * <p>
 * 支持环路, 支持负weight
 *
 * <pre>
 *     array = [0, inf, ...]
 *     for vertexes
 *         从初始点
 * </pre>
 */
public class BellmanFord extends GraphVisitor<List<Identifier>> {
    public BellmanFord(Graph g) {
        super(g);
    }

    @Override
    protected void visit(Graph graph) {

    }

    @Override
    public List<Identifier> doSolve() {
        return null;
    }
}
