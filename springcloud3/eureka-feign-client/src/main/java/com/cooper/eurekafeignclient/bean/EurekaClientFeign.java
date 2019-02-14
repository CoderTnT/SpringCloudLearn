package com.cooper.eurekafeignclient.bean;

import com.cooper.eurekafeignclient.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/14
 * @describe
 */
@FeignClient(value = "eureka-client",configuration = FeignConfig.class)
public interface EurekaClientFeign {

    @GetMapping("/hi")
    String sayHiFromClientEureka();
}
