package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;

public interface Edge {
    int SMALLEST_WEIGHT = 1;

    /**
     * @param identifier ...
     * @return 对面端点的identifier, 如果端点, 返回null
     */
    Identifier partner(Identifier identifier);
    OrderedPair<Identifier> pair();
    int getWeight();
}
