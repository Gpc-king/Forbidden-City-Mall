package com.peng.fcmall.service;

import com.peng.fcmall.pojo.LoginBean;
import com.peng.fcmall.pojo.User;

/**
 * @Author Peng
 * @Date 2022/4/23 20:54
 * @Version 1.0
 */

public interface UserService {
    /*登录*/
    User Login(LoginBean u);
    /*注册*/
    boolean Register(User user);
    /*注销*/
    boolean Delete(int id);
    /*修改*/
    boolean Update(User u);
    /*id查询*/
    User selectByID(int id);

}
