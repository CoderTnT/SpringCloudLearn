package com.cooper.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/13
 * @describe
 */
@RestController
public class HiController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String sayHi() {
        return "hi Cooper!"+port;
    }
}
