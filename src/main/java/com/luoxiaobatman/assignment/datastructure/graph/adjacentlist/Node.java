package com.luoxiaobatman.assignment.datastructure.graph.adjacentlist;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;

import java.util.Collection;
import java.util.Set;

public interface Node {
    /**
     * 与节点断开连接
     * @param identifier 节点索引
     */
    void disconnect(Identifier identifier);

    /**
     * 与节点建立连接
     * @param identifier ...
     */
    void connect(Identifier identifier);

    /**
     * 与节点建立带权重的连接
     * @param identifier ...
     * @param weight 权重
     */
    void connect(Identifier identifier, int weight);
    Identifier getIdentifier();

    /**
     * @return 图中的节点标识
     */
    Set<Identifier> adjacent();
}
