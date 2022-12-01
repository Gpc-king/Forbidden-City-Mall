package com.peng.fcmall.service.impl;

import com.peng.fcmall.dao.impl.UserDaoImpl;
import com.peng.fcmall.pojo.LoginBean;
import com.peng.fcmall.pojo.User;
import com.peng.fcmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Author Peng
 * @Date 2022/4/24 1:10
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private User user;

    /**
     * 调用Dao层的三种不同的登陆方法，为真即可
     * @param u 参数为u，分别是account和password
     * @return 布尔类型的值
     */
    @Override
    public User Login(LoginBean u) {
        System.out.println("UserServiceImpl------->" + u.toString());
        user = userDao.LoginByTel(u);
        if (user != null)
            return user;

        user = userDao.LoginByEmail(u);
        if (user != null)
            return user;

        user = userDao.LoginByMemoryCode(u);
        if (user != null)
            return user;

        return null;
    }

    /**
     * 调用Dao层的注册
     * @param user 参数user，为数据库的user的映射
     * @return 布尔类型的值
     */
    @Override
    public boolean Register(User user) {
        return userDao.Register(user);
    }

    /**
     * 调用Dao层注销
     * @param id
     * @return
     */
    @Override
    public boolean Delete(int id) {
        return userDao.delete(id);
    }

    /**
     * 修改信息
     * @param u
     * @return
     */
    @Override
    public boolean Update(User u) {
        return userDao.update(u);
    }

    /**
     * ID查询
     * @param id
     * @return
     */
    @Override
    public User selectByID(int id) {
        return userDao.selectByID(id);
    }
}
