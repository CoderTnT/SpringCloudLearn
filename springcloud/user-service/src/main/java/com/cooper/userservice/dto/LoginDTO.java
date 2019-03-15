package com.cooper.userservice.dto;

import com.cooper.userservice.entity.User;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/22
 * @describe 用于传输数据对象，某个实体类可能有100个属性，但是客户端从服务端可能只需要获取10个属性，所以用dto表示，这里dto是用户登录
 * 信息，以及,jwt  json web token
 */

public class LoginDTO {

    private User user;

    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
