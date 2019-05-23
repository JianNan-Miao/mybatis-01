package com.cheer.mybatis.po;

public class UserQueryVo {
    private  UserCustom userCustom;

    public UserQueryVo() {
    }

    public UserQueryVo(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    @Override
    public String toString() {
        return "UserQueryVo{" +
                "userCustom=" + userCustom +
                '}';
    }
}
