package com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.storage.dao;

import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.product.Product;
import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.storage.InvalidStorageAmountException;

/**
 * 仓储persistent layer
 */
public class StorageDAO {
    /**
     * 为防止超卖
     * UPDATE `storage` SET `storage_left` = ? WHERE `product_id` = ? AND `storage_left` >= ?;
     * 在数据库层防止超卖现象
     * @param product 库存的产品对象
     * @param amount 库存减少数量
     * @throws InvalidStorageAmountException 库存问题抛异常
     */
    public void decreaseStorage(Product product, int amount) throws InvalidStorageAmountException {

    }
}
