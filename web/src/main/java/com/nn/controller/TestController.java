package com.nn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    // 跳转到测试页面
    private final static String TEST = "test";

    @RequestMapping("/hello")
    public String hello(){
        return TEST;
    }
}
