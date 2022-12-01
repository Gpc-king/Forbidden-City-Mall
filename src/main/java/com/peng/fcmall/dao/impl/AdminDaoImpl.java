package com.peng.fcmall.dao.impl;

import com.peng.fcmall.dao.AdminDao;
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
 * @Date 2022/4/26 14:49
 * @Version 1.0
 */
@Transactional
@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUserInfo() {
        String sql = "SELECT * FROM user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public List<User> getAllUserInfo( int start, int size) {
        String sql = "SELECT * FROM user LIMIT ?, ?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), start, size);
        return users;
    }

    @Override
    public List<User> getAllUserInfo(String is, int start, int size) {
        String sql = "SELECT * FROM user WHERE username LIKE ? LIMIT ?, ?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), is, start, size);
        return users;
    }

    @Override
    public User getUserInfoByID(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int getCount(String is) {
        String sql = "SELECT COUNT(*) FROM user WHERE username LIKE ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, is);
    }
}
