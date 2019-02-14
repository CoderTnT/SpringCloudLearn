package com.cooper.eurekafeignclient.bean;

import org.springframework.stereotype.Component;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/14
 * @describe
 */
@Component
public class HiError implements EurekaClientFeign{

    @Override
    public String sayHiFromClientEureka() {
        return "fegin error";
    }
}
