package com.luoxiaobatman.assignment.datastructure.graph;

import com.luoxiaobatman.assignment.datastructure.support.Node;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;

import java.util.Map;

/**
 * 练习画图
 */
public interface Graph {
    /**
     * 幂等 替换节点包括删除节点所有的edge
     *
     * @param nodeIdentifier ...
     */
    void put(Identifier nodeIdentifier);

    /**
     * @param nodeIdentifier ...
     * @return null if absent, otherwise identifier previously contained in this graph
     */
    Identifier putIfAbsent(Identifier nodeIdentifier);

    void remove(Identifier nodeIdentifier);

    boolean exists(Identifier identifier);

    void connect(OrderedPair<Identifier> identifierOrderedPair);

    void connect(OrderedPair<Identifier> identifierOrderedPair, int weight);

    /**
     * 删除pair之间的连接 如果有
     *
     * @param identifierOrderedPair ...
     */
    void disconnect(OrderedPair<Identifier> identifierOrderedPair);

    Map<Identifier, Node> getNodes();
}
