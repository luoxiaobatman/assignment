package com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.order.service;

import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.order.dao.OrderDAO;
import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.product.Product;

/**
 * 仓储
 */
public class OrderService implements IOrderService {
    private OrderDAO orderDAO;

    /**
     * 下订单
     * 生成一条订单数据
     * 扣减仓库中商品数量
     * 为一个事务
     * @apiNote
     */
//    @Transaction 没有引入Spring相关框架, 因此把Transaction注释掉了, Transaction要注意事务的传播机制
    public void placeAnOrder(Product product) {
        orderDAO.insertOrder(product);
    }
}
