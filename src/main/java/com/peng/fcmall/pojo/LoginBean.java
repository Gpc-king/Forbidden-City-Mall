package com.peng.fcmall.pojo;

/**
 * @Author Peng
 * @Date 2022/4/24 0:08
 * @Version 1.0
 */

public class LoginBean {

    private String account;
    private String password;

    public LoginBean() {
    }

    public LoginBean(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
