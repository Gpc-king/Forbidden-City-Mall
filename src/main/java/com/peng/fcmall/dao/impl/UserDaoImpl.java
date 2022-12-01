package com.peng.fcmall.dao.impl;

import com.peng.fcmall.dao.UserDao;
import com.peng.fcmall.pojo.LoginBean;
import com.peng.fcmall.pojo.Product;
import com.peng.fcmall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @Author Peng
 * @Date 2022/4/24 1:01
 * @Version 1.0
 */
@Transactional
@Repository
public class UserDaoImpl implements UserDao {
    /**
     * 生成spring5中的JDBC模板
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private User user;

    /**
     * 通过手机号登录
     *
     * @param u
     * @return
     */
    @Override
    public User LoginByTel(LoginBean u) {
        System.out.println("LoginByTel -----> " + u.toString());
        String sql = "SELECT * FROM user WHERE tel = ? AND password = ?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), u.getAccount(), u.getPassword());
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    /**
     * 通过邮箱登录
     *
     * @param u
     * @return
     */
    @Override
    public User LoginByEmail(LoginBean u) {
        System.out.println("LoginByEmail -----> " + u.toString());
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), u.getAccount(), u.getPassword());
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    /**
     * 通过会员码登录
     *
     * @param u
     * @return
     */
    @Override
    public User LoginByMemoryCode(LoginBean u) {
        System.out.println("LoginByMemoryCode -----> " + u.toString());
        String sql = "SELECT * FROM user WHERE memberCode = ? AND password = ?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), u.getAccount(), u.getPassword());
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean Register(User user) {
        //为用户随机生成会员码
        if (user.getMemberCode() == null) {
            user.setMemberCode(String.format("%8d", Math.abs(new Random().nextInt())).substring(0, 9));
        }
        int admin = user.isAdmin() ? 1 : 0;
        System.out.println(user.toString());
        String sql = "INSERT INTO user(username, password, sex, address, email, tel, isAdmin, memberCode) " +
                "VALUES(?, ?, ?, ?, ?, ?, ? ,?)";
        int update = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getSex(),
                user.getAddress(), user.getEmail(), user.getTel(), admin, user.getMemberCode());
        return update > 0 ? true : false;
    }

    /**
     * 注销账号
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update > 0 ? true : false;
    }

    /**
     * 修改信息
     * @param u
     * @return
     */
    @Override
    public boolean update(User u) {
        String sql = "UPDATE user SET username = ?, password = ?, tel = ?, email = ?, sex = ?, address = ?" +
                " WHERE id = ? AND memberCode = ?";
        int update = jdbcTemplate.update(sql, u.getUsername(), u.getPassword(), u.getTel(), u.getEmail(),
                u.getSex(), u.getAddress(), u.getId(), u.getMemberCode());
        return update > 0 ? true : false;
    }

    /**
     * ID查询
     */
    @Override
    public User selectByID(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

}
