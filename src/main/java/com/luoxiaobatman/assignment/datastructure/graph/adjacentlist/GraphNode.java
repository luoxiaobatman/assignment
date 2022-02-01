package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.support.*;

/**
 *
 */
class GraphNode extends AbstractNode implements Node {
    GraphNode(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof GraphNode another)) return false;
        return this.identifier.equals(another.identifier);
    }
}
