package com.luoxiaobatman.assignment.solution;

import com.luoxiaobatman.assignment.support.Invoker;

/**
 * 做题家
 * 解由 Factory 生成
 * 可继承Factory生成解簇
 *
 * 可缓存的解 @see
 * 描述解是否稳定 @see
 * 解簇
 */
@Invoker
public interface Solution {
    Answer solve();
}
