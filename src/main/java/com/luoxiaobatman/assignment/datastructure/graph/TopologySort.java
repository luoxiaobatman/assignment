package com.luoxiaobatman.assignment.datastructure.graph;

import com.luoxiaobatman.assignment.datastructure.graph.adjacentlist.DirectedGraph;
import com.luoxiaobatman.assignment.datastructure.graph.adjacentlist.Node;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;

import java.util.ArrayList;
import java.util.List;

/**
 * 有向图 拓扑排序
 * <p>
 * based on 深度优先算法
 */
public class TopologySort extends GraphVisitor<List<Identifier>> {
    static private final Integer MARK_PERMANENT = 1;
    static private final Integer MARK_TEMPORARY = 2;
    private List<Identifier> sorted;

    public TopologySort(Graph g) {
        super(g);
    }

    @Override
    public List<Identifier> doSolve() {
        try {
            visit(graph);
        } catch (CyclicException e) {
            return null;
        }
        return sorted;
    }

    @Override
    protected void visit(Graph graph) throws CyclicException {
        sorted = new ArrayList<>();
        if (!(graph instanceof DirectedGraph)) {
            return;
        }
        for (Identifier identifier : graph.getNodes().keySet()) {
            if (!MARK_PERMANENT.equals(identifier.mark())) {
                visit(graph, identifier);
            }
        }
        System.out.println(sorted);
    }


    /**
     * node 有两个标识, permanent, temporary
     *
     * @param graph      有向图
     * @param identifier 节点标识
     * @throws CyclicException visit identifier 有 temporary标记
     */
    private void visit(Graph graph, Identifier identifier) throws CyclicException {
        if (MARK_TEMPORARY.equals(identifier.mark())) {
            throw new CyclicException();
        }
        if (MARK_PERMANENT.equals(identifier.mark())) {
            return;
        }
        identifier.mark(MARK_TEMPORARY);
        Node node = graph.getNodes().get(identifier);

        for (Identifier adjacent : node.adjacent()) {
            visit(graph, adjacent);
        }
        identifier.mark(MARK_PERMANENT);
        sorted.add(0, identifier);
    }

    private static class CyclicException extends RuntimeException {
    }
}
