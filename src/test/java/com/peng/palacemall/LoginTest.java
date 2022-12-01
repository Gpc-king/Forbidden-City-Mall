package com.peng.palacemall;

import com.peng.fcmall.pojo.LoginBean;
import com.peng.fcmall.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * @Author Peng
 * @Date 2022/4/24 1:16
 * @Version 1.0
 */

public class LoginTest {

    @Test
    public void codes(){
        System.out.println(String.format("%8d", Math.abs(new Random().nextInt())));
    }

    @Test
    public void testLogin(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springMVC.xml");
        UserServiceImpl userServiceImpl = context.getBean("userServiceImpl", UserServiceImpl.class);
        LoginBean u = new LoginBean("admin", "admin");
        System.out.println(userServiceImpl.Login(u));
    }


}
