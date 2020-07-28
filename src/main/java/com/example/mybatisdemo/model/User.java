package com.example.mybatisdemo.model;

import com.gitee.sunchenbin.mybatis.actable.annotation.*;

public class User {

    public User(String userName, String password, UserSexEnum sex){
        this.userName = userName;
        this.password = password;
        this.sex = sex;
    }

    @Column
    @IsKey
    @IsAutoIncrement
    private long id;

    @Column
    @IsNotNull
    private String userName;

    @Column
    @IsNotNull
    private String password;

    @Column
    private UserSexEnum sex;

    @Column
    private String nickName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserSexEnum getSex() {
        return sex;
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
