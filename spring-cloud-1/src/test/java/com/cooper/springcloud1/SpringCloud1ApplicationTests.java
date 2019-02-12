package com.cooper.springcloud1;

import com.cooper.dao.RedisDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.assertThat;

/*
*  测试类
* */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringCloud1ApplicationTests {

    @LocalServerPort
    private int port;
    private URL base;

    @Autowired
    RedisDao redisDao;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws  Exception {
        this.base = new URL("http://localhost:" + port + "/hi");
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void getHello() throws Exception {

        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);

        System.out.println(response.getBody());
    }


    @Test
    public void testRedis() {
        redisDao.setKey("name", "shaojie");
        redisDao.setKey("age","11");
        System.out.println(redisDao.getValue("name")+"ssssssssssssssssssssssssssssssss");
    }


}

