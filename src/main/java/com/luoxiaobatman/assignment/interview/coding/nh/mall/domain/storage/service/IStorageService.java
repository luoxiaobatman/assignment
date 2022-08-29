package com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.storage.service;

import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.product.Product;

public interface IStorageService {
    void decreaseProductStorageAmount(Product product, int amount);
}
