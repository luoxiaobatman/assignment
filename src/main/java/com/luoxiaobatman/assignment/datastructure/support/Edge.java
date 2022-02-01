package com.luoxiaobatman.assignment.datastructure.support;

/**
 * 有向的连接 ->
 *
 */
public interface Edge {
    int SMALLEST_WEIGHT = 1;

    /**
     * @param identifier ...
     * @return 对面端点的identifier, 如果端点, 返回null
     */
    Identifier partner(Identifier identifier);

    /**
     * 白子是起, 黑子为终
     */
    OrderedPair<Identifier> pair();
    int getWeight();
}
