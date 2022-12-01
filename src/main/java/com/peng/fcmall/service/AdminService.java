package com.peng.fcmall.service;

import com.peng.fcmall.pojo.User;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/26 14:57
 * @Version 1.0
 */

public interface AdminService {
    /*查询所有用户信息*/
    List<User> getAllUserInfo();
    /*查询所有用户信息*/
    List<User> getAllUserInfo(String is, int start, int size);
    /*通过ID查询信息*/
    User getUserInfoByID(int id);
    /*查询总行数*/
    int getCount(String is);
}
