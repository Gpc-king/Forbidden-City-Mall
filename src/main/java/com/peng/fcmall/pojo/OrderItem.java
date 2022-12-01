package com.peng.fcmall.pojo;

import java.util.Date;

/**
 * @Author Peng
 * @Date 2022/4/27 13:34
 * @Version 1.0
 */

public class OrderItem {
    private String memberCode;
    private String username;
    private int price;
    private String cate;
    private String time;

    public OrderItem() {
    }

    public OrderItem(String memberCode, String username, int price, String cate, String time) {
        this.memberCode = memberCode;
        this.username = username;
        this.price = price;
        this.cate = cate;
        this.time = time;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "memberCode='" + memberCode + '\'' +
                ", username='" + username + '\'' +
                ", price=" + price +
                ", cate='" + cate + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
