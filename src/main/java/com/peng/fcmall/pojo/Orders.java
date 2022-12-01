package com.peng.fcmall.pojo;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Author Peng
 * @Date 2022/4/27 10:18
 * @Version 1.0
 */
@Repository
public class Orders {
    private int id;
    private int user_id;
    private int order_status = 1;
    private Date date;
    private int price;
    private int order_pay;

    public Orders() {
    }

    public Orders(int id, int user_id, int order_status, Date date, int price, int order_pay) {
        this.id = id;
        this.user_id = user_id;
        this.order_status = order_status;
        this.date = date;
        this.price = price;
        this.order_pay = order_pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public long getDate() {
        return new Date().getTime();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrder_pay() {
        return (int)(Math.random()*1+3);
    }

    public void setOrder_pay(int order_pay) {
        this.order_pay = order_pay;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", order_status=" + order_status +
                ", date=" + date +
                ", price=" + price +
                ", order_pay=" + order_pay +
                '}';
    }
}
