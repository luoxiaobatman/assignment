package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;

public class UndirectedGraph extends AbstractGraph implements Graph{
    @Override
    public void connect(OrderedPair<Identifier> identifierOrderedPair, int weight) {
        putIfAbsent(identifierOrderedPair.white);
        putIfAbsent(identifierOrderedPair.black);
        nodes.get(identifierOrderedPair.white).connect(identifierOrderedPair.black, weight);
        nodes.get(identifierOrderedPair.black).connect(identifierOrderedPair.white, weight);
    }
}
