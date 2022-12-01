package com.peng.fcmall.dao;

import com.peng.fcmall.pojo.LoginBean;
import com.peng.fcmall.pojo.User;

/**
 * @Author Peng
 * @Date 2022/4/24 0:59
 * @Version 1.0
 */

public interface UserDao {

    /*电话登录*/
    User LoginByTel(LoginBean u);
    /*邮箱登录*/
    User LoginByEmail(LoginBean u);
    /*会员码登录*/
    User LoginByMemoryCode(LoginBean u);
    /*注册账号*/
    boolean Register(User user);
    /*注销账号*/
    boolean delete(int id);
    /*修改信息*/
    boolean update(User user);
    /*ID查询*/
    User selectByID(int id);
}
