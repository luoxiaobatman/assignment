package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.graph.Graph;
import com.luoxiaobatman.assignment.datastructure.graph.GraphVisitor;
import com.luoxiaobatman.assignment.datastructure.support.Edge;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.Node;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;
import com.luoxiaobatman.assignment.designpattern.behavior.vistor.Visitor;

import java.util.*;
import java.util.function.Consumer;

public abstract class AbstractGraph implements Graph, Consumer<Visitor> {
    protected final Map<Identifier, Node> nodes = new HashMap<>();

    @Override
    public void put(Identifier nodeIdentifier) {
        remove(nodeIdentifier);
        nodes.put(nodeIdentifier, new GraphNode(nodeIdentifier));
    }

    @Override
    public Identifier putIfAbsent(Identifier nodeIdentifier) {
        Node existedNode = nodes.putIfAbsent(nodeIdentifier, new GraphNode(nodeIdentifier));
        if (existedNode == null) {
            return null;
        }
        return existedNode.getIdentifier();
    }

    @Override
    public void remove(Identifier nodeIdentifier) {
        Node existedNode = nodes.get(nodeIdentifier);
        if (existedNode != null) {
            remove(existedNode);
        }
    }

    private void remove(Node node) {
        nodes.remove(node.getIdentifier());
        for (Identifier identifier : node.adjacent()) {
            nodes.get(identifier).disconnect(node.getIdentifier());
        }
    }

    @Override
    public boolean exists(Identifier identifier) {
        return nodes.containsKey(identifier);
    }

    @Override
    public void connect(OrderedPair<Identifier> identifierOrderedPair) {
        connect(identifierOrderedPair, Edge.SMALLEST_WEIGHT);
    }
    @Override
    public void disconnect(OrderedPair<Identifier> identifierOrderedPair) {
        nodes.get(identifierOrderedPair.white).disconnect(identifierOrderedPair.black);
        nodes.get(identifierOrderedPair.black).disconnect(identifierOrderedPair.white);
    }

    @Override
    public void accept(Visitor visitor) {
        if (visitor instanceof GraphVisitor) {
            visitor.visit(this);
        }
    }

    @Override
    public Map<Identifier, Node> getNodes() {
        return nodes;
    }
}
