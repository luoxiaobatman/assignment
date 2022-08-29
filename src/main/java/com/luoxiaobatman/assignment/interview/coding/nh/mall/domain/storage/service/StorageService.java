package com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.storage.service;

import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.product.Product;
import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.storage.dao.StorageDAO;

public class StorageService implements IStorageService {
    private StorageDAO storageDAO;

    @Override
//    @Transaction
    public void decreaseProductStorageAmount(Product product, int amount) {
        storageDAO.decreaseStorage(product, amount);
    }
}
