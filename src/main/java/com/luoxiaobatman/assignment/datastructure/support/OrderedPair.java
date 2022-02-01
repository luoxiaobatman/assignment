package com.luoxiaobatman.assignment.datastructure.support;

public final class OrderedPair<E> {
    public static<E> OrderedPair<E> of(E white, E black) {
        return new OrderedPair<>(white, black);
    }

    OrderedPair(E white, E black) {
        this.black = black;
        this.white = white;
    }

    /**
     * 白子是起
     */
    public final E white;

    /**
     * 黑子为终
     */
    public final E black;

    public E viceVersa(E vice) {
        if (white.equals(vice)) {
            return black;
        } else if (black.equals(white)) {
            return white;
        }
        return null;
    }
}
