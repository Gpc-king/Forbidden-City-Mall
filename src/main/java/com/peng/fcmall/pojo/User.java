package com.peng.fcmall.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author Peng
 * @Date 2022/4/24 7:19
 * @Version 1.0
 */
@Component
public class User {

    private int id;
    private String username;
    private String password;
    private String address;
    private String tel;
    private String sex;
    private String email;
    private String isAdmin;
    private String memberCode;

    public User() {
    }

    public User(int id, String username, String password, String address, String tel, String sex, String email, String isAdmin, String memberCode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.tel = tel;
        this.sex = sex;
        this.email = email;
        this.isAdmin = isAdmin;
        this.memberCode = memberCode;
    }

    public boolean isAdmin() {
        return "1".equals(isAdmin) ? true : false;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", memberCode='" + memberCode + '\'' +
                '}';
    }
}
