package com.peng.fcmall.service;

import com.peng.fcmall.pojo.Product;
import com.peng.fcmall.pojo.User;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/24 19:18
 * @Version 1.0
 */

public interface ProductService {
    /*获取所有产品*/
    List<Product> getAllProduct();
    /*按类型获取产品*/
    List<Product> getAllProductByCate(String type);
    /*按ID获取产品*/
    Product getAllProduct(int id);
    /*库存删减*/
    boolean setReducePNum(int id, int num);
    /*库存增加*/
    boolean setAddPNum(int id, int num);
    /*查询所有用户信息*/
    List<Product> getAllProduct(String is, int start, int size);
    /*查询总行数*/
    int getCount(String is);
}
