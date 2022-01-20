package com.luoxiaobatman.assignment.support.solution;

import com.luoxiaobatman.assignment.support.Invoker;

@Invoker
public interface GenericSolution<T> {
    GenericAnswer<T> solve();
}
