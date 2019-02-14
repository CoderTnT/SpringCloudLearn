package com.cooper.eurekafeignclient.controller;

import com.cooper.eurekafeignclient.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/14
 * @describe
 */
@RestController
public class HiController {
    @Autowired
    HiService hiService;

    @GetMapping("/hi")
    public String sayHi() {
        return hiService.sayHi();
    }
}
