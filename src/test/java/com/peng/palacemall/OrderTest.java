package com.peng.palacemall;

import com.peng.fcmall.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Peng
 * @Date 2022/4/27 13:48
 * @Version 1.0
 */

public class OrderTest {

    @Test
    public void getAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springMVC.xml");
        OrderServiceImpl orderServiceImpl = context.getBean("orderServiceImpl", OrderServiceImpl.class);
        System.out.println(orderServiceImpl.getOrder());
    }
}
