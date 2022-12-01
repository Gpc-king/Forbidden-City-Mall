package com.peng.fcmall.service.impl;

import com.peng.fcmall.dao.impl.AdminDaoImpl;
import com.peng.fcmall.pojo.User;
import com.peng.fcmall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/26 14:58
 * @Version 1.0
 */
@Repository
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDaoImpl adminDao;

    @Override
    public List<User> getAllUserInfo() {
        return adminDao.getAllUserInfo();
    }

    @Override
    public List<User> getAllUserInfo(String is, int start, int size) {
        if (is == null || " ".equals(is) || "".equals(is)) {
            return adminDao.getAllUserInfo( start, size);
        } else {
            return adminDao.getAllUserInfo("%" + is + "%", start, size);
        }
    }

    @Override
    public User getUserInfoByID(int id) {
        return adminDao.getUserInfoByID(id);
    }

    @Override
    public int getCount(String is) {
        if (is == null || " ".equals(is) || "".equals(is)) {
            return adminDao.getCount();
        } else {
            return adminDao.getCount("%" + is + "%");
        }
    }
}
