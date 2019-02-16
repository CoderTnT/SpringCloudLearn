package com.cooper.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/16
 * @describe
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/hi")
    public String hi(){ return  "hi  i'm cooper";}

}
