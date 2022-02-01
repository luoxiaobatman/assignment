package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.support.EdgeImpl;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;
import com.luoxiaobatman.assignment.datastructure.support.StringIdentifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeImplTest {

    @Test
    void testAll() {
        int weight = 1;
        Identifier white = new StringIdentifier("1");
        Identifier black = new StringIdentifier("2");

        OrderedPair<Identifier> pair = OrderedPair.of(white, black);
        EdgeImpl edge = new EdgeImpl(pair, weight);
        assertEquals(edge.partner(white), black);
        assertEquals(edge.partner(black), white);

        Identifier dangle = new StringIdentifier("3");
        assertNull(edge.partner(dangle));
        assertSame(edge.pair(), pair);
        assertSame(edge.getWeight(), weight);
    }

}
