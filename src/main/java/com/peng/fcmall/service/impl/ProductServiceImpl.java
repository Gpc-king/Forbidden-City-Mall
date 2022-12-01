package com.peng.fcmall.service.impl;

import com.peng.fcmall.dao.ProductDao;
import com.peng.fcmall.dao.impl.ProductDaoImpl;
import com.peng.fcmall.pojo.Product;
import com.peng.fcmall.pojo.User;
import com.peng.fcmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Peng
 * @Date 2022/4/24 19:18
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDaoImpl productDao;

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public List<Product> getAllProductByCate(String type) {
        return productDao.getAllProductByCate(type);
    }

    @Override
    public Product getAllProduct(int id) {
        return productDao.getAllProduct(id);
    }

    @Override
    public boolean setReducePNum(int id, int num) {
        return productDao.setReducePNum(id, num);
    }

    @Override
    public boolean setAddPNum(int id, int num) {
        return productDao.setAddPNum(id, num);
    }

    @Override
    public List<Product> getAllProduct(String is, int start, int size) {
        if ("all".equals(is)) {
            return productDao.getAllProduct( start, size);
        } else {
            return productDao.getAllProduct( is, start, size);
        }
    }

    @Override
    public int getCount(String is) {
        if ("all".equals(is)) {
            return productDao.getCount();
        } else {
            return productDao.getCount(is);
        }
    }
}
