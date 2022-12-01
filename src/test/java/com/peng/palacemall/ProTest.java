package com.peng.palacemall;

import com.peng.fcmall.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Peng
 * @Date 2022/4/24 19:22
 * @Version 1.0
 */

public class ProTest {

    @Test
    public void getAllPro(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springMVC.xml");
        ProductServiceImpl productServiceImpl = context.getBean("productServiceImpl", ProductServiceImpl.class);
        System.out.println(productServiceImpl.getAllProduct());
    }

    @Test
    public void getAllPro1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springMVC.xml");
        ProductServiceImpl productServiceImpl = context.getBean("productServiceImpl", ProductServiceImpl.class);
        System.out.println(productServiceImpl.getAllProduct(1).toString());
    }

    @Test
    public void getAllPro2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springMVC.xml");
        ProductServiceImpl productServiceImpl = context.getBean("productServiceImpl", ProductServiceImpl.class);
        System.out.println(productServiceImpl.getCount("猫主子们"));
        System.out.println(productServiceImpl.getAllProduct("all", 0, 5));
    }
}
