package com.peng.fcmall.pojo;

import org.springframework.stereotype.Component;

/**
 * @Author Peng
 * @Date 2022/4/24 19:02
 * @Version 1.0
 */
@Component
public class Product {
    private int PID;
    private String PName;
    private float PPrice;
    private int PNum;
    private String PDetail;
    private String PCate;

    public Product() {
    }

    public Product(int PID, String PName, float PPrice, int PNum, String PDetail, String PCate) {
        this.PID = PID;
        this.PName = PName;
        this.PPrice = PPrice;
        this.PNum = PNum;
        this.PDetail = PDetail;
        this.PCate = PCate;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public float getPPrice() {
        return PPrice;
    }

    public void setPPrice(float PPrice) {
        this.PPrice = PPrice;
    }

    public int getPNum() {
        return PNum;
    }

    public void setPNum(int PNum) {
        this.PNum = PNum;
    }

    public String getPDetail() {
        return PDetail;
    }

    public void setPDetail(String PDetail) {
        this.PDetail = PDetail;
    }

    public String getPCate() {
        return PCate;
    }

    public void setPCate(int PCate) {
        String[] cate = {"猫主子们", "文创用品", "中国节日", "温馨家具", "可爱包包"};
        this.PCate = cate[PCate-1];
    }

    @Override
    public String toString() {
        return "Product{" +
                "PID=" + PID +
                ", PName='" + PName + '\'' +
                ", PPrice=" + PPrice +
                ", PNum=" + PNum +
                ", PDetail='" + PDetail + '\'' +
                ", PCate=" + PCate +
                '}';
    }
}
