package com.cooper.userservice.controller;

import com.cooper.userservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/22
 * @describe
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value="登录",notes = "username和password为必选项")
    @PostMapping("/login")
    public RespDTO login(@RequestParam String username,@RequestParam String password) {

        return userService.login(username, password);
    }

}
