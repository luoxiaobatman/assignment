package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
class StandardNode implements Node {
    /**
     * node 的全局唯一标识
     */
    private final Identifier identifier;

    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public Set<Identifier> adjacent() {
        return edges.values().stream()
                .map(edge -> edge.partner(this.identifier)).collect(Collectors.toSet());
    }

    private final Map<Identifier, Edge> edges = new HashMap<>();

    StandardNode(Identifier identifier) {
        this.identifier = identifier;
    }

    @Override
    public void disconnect(Identifier identifier) {
        edges.remove(this.identifier);
    }

    @Override
    public void connect(Identifier identifier) {
        connect(identifier, Edge.SMALLEST_WEIGHT);
    }

    @Override
    public void connect(Identifier identifier, int weight) {
        edges.put(identifier, new EdgeImpl(OrderedPair.of(this.identifier, identifier), weight));
    }

    @Override
    public int hashCode() {
        return identifier.id().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof StandardNode another)) return false;
        return this.identifier.equals(another.identifier);
    }
}
