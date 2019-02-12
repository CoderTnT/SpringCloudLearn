package com.cooper.controller;

import com.cooper.entity.User;
import com.cooper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
