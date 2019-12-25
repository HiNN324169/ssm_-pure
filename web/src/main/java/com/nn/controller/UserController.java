package com.nn.controller;

import com.nn.entity.User;
import com.nn.service.UserService;
import com.nn.service.imp.UserServiceImp;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    // 日志 输出
    private static Logger logger = Logger.getLogger(UserController.class);

    @Resource(type = UserServiceImp.class)
    private UserService userService;

    @RequestMapping("/user")
    public @ResponseBody Object queryAll(){
        List<User> users = userService.queryAll();
        logger.info(users.toString());
        return users;
    }
}
