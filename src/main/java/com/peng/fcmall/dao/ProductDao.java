package com.peng.fcmall.dao;

import com.peng.fcmall.pojo.Product;
import com.peng.fcmall.pojo.User;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/24 19:01
 * @Version 1.0
 */

public interface ProductDao {
    /*获取所有产品*/
    List<Product> getAllProduct();
    /*按类型*/
    List<Product> getAllProductByCate(String type);
    /*按ID获取产品*/
    Product getAllProduct(int id);
    /*库存删减*/
    boolean setReducePNum(int id, int num);
    /*库存增加*/
    boolean setAddPNum(int id, int num);
    /*查询所有产品信息 无参*/
    List<Product> getAllProduct(int start, int size);
    /*查询所有产品信息 有参*/
    List<Product> getAllProduct(String is, int start, int size);
    /*获取总页数 无参*/
    int getCount();
    /*获取总页数 有参*/
    int getCount(String is);
}
