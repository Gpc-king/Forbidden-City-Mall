package com.peng.fcmall.service.impl;

import com.peng.fcmall.dao.OrderDao;
import com.peng.fcmall.dao.impl.OrderDaoImpl;
import com.peng.fcmall.pojo.OrderItem;
import com.peng.fcmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/27 13:46
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDaoImpl orderDao;

    @Override
    public List<OrderItem> getOrder() {
        return orderDao.getOrder();
    }
}
