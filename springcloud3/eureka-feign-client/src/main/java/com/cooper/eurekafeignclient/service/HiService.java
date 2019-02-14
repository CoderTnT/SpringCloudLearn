package com.cooper.eurekafeignclient.service;

import com.cooper.eurekafeignclient.bean.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/14
 * @describe
 */
@Service
public class HiService {

    @Autowired
    EurekaClientFeign eurekaClientFeign;

    public String sayHi() {
        return eurekaClientFeign.sayHiFromClientEureka();
    }
}
