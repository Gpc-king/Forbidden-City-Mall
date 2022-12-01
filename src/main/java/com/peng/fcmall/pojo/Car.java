package com.peng.fcmall.pojo;

import org.springframework.stereotype.Component;

/**
 * @Author Peng
 * @Date 2022/4/25 16:57
 * @Version 1.0
 */
@Component
public class Car {
    private int num;
    private Product product;

    public Car() {
    }

    public Car(int num, Product product) {
        this.num = num;
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Car{" +
                "num=" + num +
                ", product=" + product +
                '}';
    }
}
