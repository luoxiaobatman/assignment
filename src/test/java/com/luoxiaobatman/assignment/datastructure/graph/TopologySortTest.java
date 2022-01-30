package com.luoxiaobatman.assignment.datastructure.graph;

import com.luoxiaobatman.assignment.datastructure.graph.adjacentlist.DirectedGraph;
import com.luoxiaobatman.assignment.datastructure.support.CharacterIdentifier;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;
import com.luoxiaobatman.assignment.support.NoopArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.StringsArgumentsParser;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopologySortTest {

    @ParameterizedTest
    @SolutionSource(value = {
//            "ab,bc,cd,a", "abcd",
//            "ab,bc,cd,da", "",
//            "ab,bc,bd,cd", "abcd",
//            "ab,ac,cd", "acdb",
//            "ab", "ab",
            "a", "a",
    }, argumentsCount = 2, argumentsParsers = {StringsArgumentsParser.class, NoopArgumentsParser.class}, delimiter = ",")
    void visit(String[] rawEdges, String expected) {
        Graph graph = new DirectedGraph();
        for (String rawEdge : rawEdges) {
            if (rawEdge.length() == 1) {
                graph.putIfAbsent(new CharacterIdentifier(rawEdge.charAt(0)));
            } else {
                graph.connect(OrderedPair.of(
                        new CharacterIdentifier(rawEdge.charAt(0)),
                        new CharacterIdentifier(rawEdge.charAt(1))));
            }
        }
        List<Identifier> sorted = Solver.solve(TopologySort.class, graph);
        String actual = "";
        if (sorted != null) {
            StringBuilder sb = new StringBuilder();
            sorted.forEach(sb::append);
            actual = sb.toString();
        }
        assertEquals(expected, actual);
    }
}
