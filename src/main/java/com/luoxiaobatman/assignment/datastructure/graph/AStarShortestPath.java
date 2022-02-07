package com.luoxiaobatman.assignment.datastructure.graph;

import com.luoxiaobatman.assignment.datastructure.support.Edge;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用AStar算法搜索权重有向图两点之间的最短路径
 */
public class AStarShortestPath extends GraphVisitor<List<Edge>> {
    private List<Edge> shortestPath;
    private final Identifier start;
    private final Identifier end;
    private final int maxStep;

    public AStarShortestPath(Graph g, Identifier start, Identifier end, int maxStep) {
        super(g);
        this.start = start;
        this.end = end;
        this.maxStep = maxStep;
    }

    @Override
    protected void visit(Graph graph) {
        shortestPath = null;
        if (maxStep <= 0 || !graph.exists(start) || !graph.exists(end)) return;
        aStarShortestPath();
    }

    private void aStarShortestPath() {
        Map<Identifier, Holder> shortestPathMap = new HashMap<>();
        shortestPathMap.put(start, new Holder());
        for (int i = 0; i < maxStep; i++) {
            for (Identifier dst : shortestPathMap.keySet()) {
                Holder dstHolder = shortestPathMap.get(dst);
                Map<Identifier, Edge> edges = graph.getNodes().get(dst).edges();
                for (Identifier nextDst : edges.keySet()) {
                    Edge edge = edges.get(nextDst);
                    Holder nextDstHolder = shortestPathMap.get(nextDst);
                    if (nextDstHolder == null) {
                        nextDstHolder = new Holder(dstHolder);
                        nextDstHolder.add(edge);
                    } else {
                        if (dstHolder.weightSum + edge.getWeight() < nextDstHolder.weightSum) {
                            nextDstHolder = new Holder(dstHolder);
                            nextDstHolder.add(edge);
                        }
                    }
                    shortestPathMap.put(nextDst, nextDstHolder);
                }
            }
        }

        if (shortestPathMap.containsKey(end)) {
            shortestPath = shortestPathMap.get(end).shortestPath;
        }
    }

    private static class Holder {
        int weightSum;
        List<Edge> shortestPath;

        private Holder(Holder holder) {
            weightSum = holder.weightSum;
            if (holder.shortestPath.size() == 0) {
                shortestPath = new ArrayList<>();
            } else {
                shortestPath = holder.shortestPath.subList(0, holder.shortestPath.size());
            }
        }

        private Holder() {
            shortestPath = new ArrayList<>();
        }

        private void add(Edge edge) {
            weightSum = weightSum + edge.getWeight();
            shortestPath.add(edge);
        }
    }

    @Override
    public List<Edge> doSolve() {
        visit(graph);
        return shortestPath;
    }
}
