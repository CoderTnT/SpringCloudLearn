package com.cooper.eurekaribbonclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/13
 * @describe
 */
@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hierror")
    public String hi(String name) {
        return restTemplate.getForObject("http://eureka-client/hi", String.class);
    }

    public String hierror(String name) {
        return "make a mistake" +name;
    }
}
