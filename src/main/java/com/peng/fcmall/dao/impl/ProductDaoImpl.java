package com.peng.fcmall.dao.impl;

import com.peng.fcmall.dao.ProductDao;
import com.peng.fcmall.pojo.Product;
import com.peng.fcmall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/24 19:07
 * @Version 1.0
 */
@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProduct() {
        String sql = "SELECT * FROM product WHERE PNum > 0";
        List<Product> productInfoList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
        return productInfoList;
    }

    @Override
    public List<Product> getAllProductByCate(String type) {
        String sql = "SELECT * FROM product p, pcate c WHERE p.PCate = c.id AND c.mold = ?";
        List<Product> productInfoList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), type);
        return productInfoList;
    }

    @Override
    public Product getAllProduct(int id) {
        String sql = "SELECT * FROM product WHERE PID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Product>(Product.class), id);
    }

    @Override
    public boolean setReducePNum(int id, int num) {
        String sql = "UPDATE product SET PNum = PNum - ? WHERE PID = ?";
        int update = jdbcTemplate.update(sql, num, id);
        return update > 0 ? true : false;
    }

    @Override
    public boolean setAddPNum(int id, int num) {
        String sql = "UPDATE product SET PNum = PNum + ? WHERE PID = ?";
        int update = jdbcTemplate.update(sql, num, id);
        return update > 0 ? true : false;
    }

    @Override
    public List<Product> getAllProduct(int start, int size) {
        String sql = "SELECT * FROM product LIMIT ?, ?";
        List<Product> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), start, size);
        return products;
    }

    @Override
    public List<Product> getAllProduct(String is, int start, int size) {
        String sql = "SELECT * FROM product p, pcate pc WHERE p.PCate = pc.id AND pc.mold = ? LIMIT ?, ?";
        List<Product> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), is, start, size);
        return products;
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM product";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int getCount(String is) {
        String sql = "SELECT COUNT(*) FROM product p, pcate pc WHERE p.PCate = pc.id AND pc.mold = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, is);
    }
}
