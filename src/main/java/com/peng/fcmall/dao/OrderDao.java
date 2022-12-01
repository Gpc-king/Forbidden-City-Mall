package com.peng.fcmall.dao;

import com.peng.fcmall.pojo.OrderItem;
import com.peng.fcmall.pojo.Orders;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/27 11:28
 * @Version 1.0
 */

public interface OrderDao {

    /*生成订单*/
    void createOrder(Orders o);

    /*获取订单*/
    List<OrderItem> getOrder();


}
