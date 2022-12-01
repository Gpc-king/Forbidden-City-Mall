package com.peng.palacemall;

import com.peng.fcmall.dao.impl.AdminDaoImpl;
import com.peng.fcmall.dao.impl.UserDaoImpl;
import com.peng.fcmall.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Peng
 * @Date 2022/4/26 14:54
 * @Version 1.0
 */

public class UserTest {

    @Test
    public void getAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springMVC.xml");
        AdminDaoImpl adminDaoImpl = context.getBean("adminDaoImpl", AdminDaoImpl.class);
        System.out.println(adminDaoImpl.getAllUserInfo(1, 2));
    }

    @Test
    public void getByID(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springMVC.xml");
        AdminDaoImpl adminDaoImpl = context.getBean("adminDaoImpl", AdminDaoImpl.class);
        System.out.println(adminDaoImpl.getUserInfoByID(1).toString());
    }

    @Test
    public void getCount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springMVC.xml");
        AdminServiceImpl adminSeviceImpl = context.getBean("adminServiceImpl", AdminServiceImpl.class);
        System.out.println(adminSeviceImpl.getAllUserInfo("i", 0, 1));
    }
}
