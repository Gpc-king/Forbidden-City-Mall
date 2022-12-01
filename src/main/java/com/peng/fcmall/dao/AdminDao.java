package com.peng.fcmall.dao;

import com.peng.fcmall.pojo.User;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/26 14:36
 * @Version 1.0
 */

public interface AdminDao {

    /*查询所有用户信息 无参*/
    List<User> getAllUserInfo();
    /*查询所有用户信息 无参*/
    List<User> getAllUserInfo(int start, int size);
    /*查询所有用户信息 有参*/
    List<User> getAllUserInfo(String is, int start, int size);
    /*通过ID查询信息*/
    User getUserInfoByID(int id);
    /*获取总页数 无参*/
    int getCount();
    /*获取总页数 有参*/
    int getCount(String is);

}
