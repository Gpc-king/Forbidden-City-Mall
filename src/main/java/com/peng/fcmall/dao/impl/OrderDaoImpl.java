package com.peng.fcmall.dao.impl;

import com.peng.fcmall.dao.OrderDao;
import com.peng.fcmall.pojo.OrderItem;
import com.peng.fcmall.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/27 11:28
 * @Version 1.0
 */
@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createOrder(Orders o) {
        String sql = "INSERT INTO orders(user_id, order_status, time, price, order_pay) VALUES(?, ?, ?, ?, ?)";
        int update = jdbcTemplate.update(sql, o.getUser_id(), o.getOrder_status(), new Date(o.getDate()), o.getPrice(), o.getOrder_pay());
    }

    @Override
    public List<OrderItem> getOrder() {
        String sql = "SELECT u.memberCode, u.username, o.price, p.cate, o.time FROM orders o, user u,paycate p WHERE o.user_id = u.id AND o.order_pay = p.id";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderItem.class));
    }
}
