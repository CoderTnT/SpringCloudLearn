package com.cooper.eurekaribbonclient.controller;

import com.cooper.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/13
 * @describe
 */
@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi() {
        return ribbonService.hi("sd");
    }
}
