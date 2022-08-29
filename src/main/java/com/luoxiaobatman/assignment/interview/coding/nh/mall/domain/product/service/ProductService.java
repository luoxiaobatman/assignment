package com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.product.service;

import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.order.service.IOrderService;
import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.product.Product;
import com.luoxiaobatman.assignment.interview.coding.nh.mall.domain.storage.service.IStorageService;

public class ProductService implements IProductService{
    private IOrderService orderService;
    private IStorageService storageService;

    /**
     * 实现
     * 依赖于dao层(一般是数据库)对transaction的支持.
     * mysql innodb存储引擎支持 myisam 不支持
     *
     * 如果数据库不支持ACID事务, 譬如使用的redis这样的内存数据库,
     * 或者大部门nosql数据库, 也可中间加一层zookeeper依赖, 挂个分布式锁来提供部分一致性支持.
     * 当然不支持事务的数据, 遇到故障后, 一致性也会出现问题.
     *
     * @param product 购买的产品
     * @return 失败提示, null成功, 因此跑
     */
    @Override
//    @Transaction
    public String buyProduct(Product product) {
        // TODO transaction失败逻辑, 返回相应的提示
        storageService.decreaseProductStorageAmount(product, 1);
        orderService.placeAnOrder(product);
        return null;
    }
}
