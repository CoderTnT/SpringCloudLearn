package com.cooper.controller;

import com.cooper.entity.User;
import com.cooper.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/12
 * @describe
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }


    @ApiOperation(value="用户列表",notes = "用户列表")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = userService.findAll();
        return users;
    }


    @ApiOperation(value = "获取用户信息", notes = "根据url里面的id来获取详细信息")
    @RequestMapping(value = {"/id"}, method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return user;
    }

}
