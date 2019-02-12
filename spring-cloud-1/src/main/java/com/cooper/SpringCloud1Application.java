package com.cooper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloud1Application {

    @Value("${age}")
    private int age;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud1Application.class, args);
    }

    @GetMapping("hi")
    public String hi() {
        return "Hi,I'm Cooper!"+" ,age:"+age;
    }



}

