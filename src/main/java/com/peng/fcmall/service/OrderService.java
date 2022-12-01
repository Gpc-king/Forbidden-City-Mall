package com.peng.fcmall.service;

import com.peng.fcmall.pojo.OrderItem;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/27 13:45
 * @Version 1.0
 */

public interface OrderService {
    /*获取订单*/
    List<OrderItem> getOrder();
}
