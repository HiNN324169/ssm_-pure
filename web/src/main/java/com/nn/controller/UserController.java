package com.nn.controller;

import com.nn.service.UserService;
import com.nn.service.imp.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource(type = UserServiceImp.class)
    private UserService userService;

    @RequestMapping("/user")
    public @ResponseBody Object queryAll(){


        return userService.queryAll();
    }
}
