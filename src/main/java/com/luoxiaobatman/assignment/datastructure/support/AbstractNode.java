package com.luoxiaobatman.assignment.datastructure.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractNode implements Node {
    /**
     * node 的全局唯一标识
     */
    protected final Identifier identifier;

    private final Map<Identifier, Edge> edges = new HashMap<>();

    protected AbstractNode(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public Set<Identifier> adjacent() {
        return edges.values().stream()
                .map(edge -> edge.partner(this.identifier)).collect(Collectors.toSet());
    }

    @Override
    public void disconnect(Identifier identifier) {
        edges.remove(identifier);
    }

    @Override
    public void connect(Identifier identifier, int weight) {
        if (identifier != null) {
            edges.put(identifier, new EdgeImpl(OrderedPair.of(this.identifier, identifier), weight));
        }
    }

    @Override
    public void connect(Identifier identifier) {
        connect(identifier, Edge.SMALLEST_WEIGHT);
    }

    @Override
    public int hashCode() {
        return identifier.id().hashCode();
    }

    @Override
    public Map<Identifier, Edge> edges() {
        return edges;
    }
}
