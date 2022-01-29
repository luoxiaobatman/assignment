package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.support.AbstractIdentifier;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;
import lombok.AllArgsConstructor;

public class Main {
    public static void main(String[] args) {
        Graph graph = new UndirectedGraph();
        StringIdentifier stringIdentifier1 = new StringIdentifier("1");
        StringIdentifier stringIdentifier2 = new StringIdentifier("2");
        graph.connect(OrderedPair.of(stringIdentifier1, stringIdentifier2));
        graph.bfs(identifier -> {
            System.out.println(identifier);
        });

//        System.out.println(graph);
    }

    @AllArgsConstructor
    public static class StringIdentifier extends AbstractIdentifier implements Identifier {
        private final String id;
        @Override
        public String id() {
            return id;
        }
    }
}
