package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.StringIdentifier;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StandardNodeTest {

    @Test
    void getIdentifier() {
        Identifier identifier = new StringIdentifier("1");
        StandardNode node = new StandardNode(identifier);
        assertSame(node.getIdentifier(), identifier);
    }

    /**
     * connect 和 disconnect 能改变相邻
     * connect 和 disconnect 幂等
     */
    @Test
    void testConnectivity() {
        StandardNode node = new StandardNode(new StringIdentifier("1"));
        assertTrue(node.adjacent().isEmpty());
        node.disconnect(new StringIdentifier("2"));
        assertTrue(node.adjacent().isEmpty());

        Set<Identifier> connected = new HashSet<>();
        for (int i = 2; i < 10; i++) {
            connected.add(new StringIdentifier("" + i));
        }
        for (int i = 2; i < 10; i++) {
            connected.add(new StringIdentifier("" + i));
        }
        for (Identifier connectedIdentifier : connected) {
            node.connect(connectedIdentifier);
        }
        Set<Identifier> adjacent = node.adjacent();
        adjacent.containsAll(connected);
        connected.containsAll(adjacent);
        Identifier toDisconnectIdentifier = new StringIdentifier("2");
        connected.remove(toDisconnectIdentifier);
        node.disconnect(toDisconnectIdentifier);
        adjacent.containsAll(connected);
        connected.containsAll(adjacent);
    }
}