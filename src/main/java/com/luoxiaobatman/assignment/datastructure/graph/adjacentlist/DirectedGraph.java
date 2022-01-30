package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.graph.Graph;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;

public class DirectedGraph extends AbstractGraph implements Graph {
    @Override
    public void connect(OrderedPair<Identifier> identifierOrderedPair, int weight) {
        Identifier white = putIfAbsent(identifierOrderedPair.white);
        if (white == null) {
            white = identifierOrderedPair.white;
        }
        Identifier black = putIfAbsent(identifierOrderedPair.black);
        if (black == null) {
            black = identifierOrderedPair.black;;
        }
        nodes.get(white).connect(black, weight);
    }
}
