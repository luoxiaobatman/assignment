package com.luoxiaobatman.assignment.datastructure.support;

/**
 * Edge的一个默认实现, 不带有附加信息
 */
public class EdgeImpl implements Edge {
    private final int weight;
    private final OrderedPair<Identifier> identifierOrderedPair;

    public EdgeImpl(OrderedPair<Identifier> identifierOrderedPair, int weight) {
        this.weight = Math.max(Edge.SMALLEST_WEIGHT, weight);
        this.identifierOrderedPair = identifierOrderedPair;
    }

    @Override
    public Identifier partner(Identifier identifier) {
        if (identifier == identifierOrderedPair.white) return identifierOrderedPair.black;
        if (identifier == identifierOrderedPair.black) return identifierOrderedPair.white;
        return null;
    }

    @Override
    public OrderedPair<Identifier> pair() {
        return identifierOrderedPair;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
