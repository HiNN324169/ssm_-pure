package com.nn.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nn.entity.User;
import com.nn.service.UserService;
import com.nn.service.imp.UserServiceImp;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private static final String DOWN = "down";
    // 日志 输出
    private static Logger logger = Logger.getLogger(UserController.class);

    @Resource(type = UserServiceImp.class)
    private UserService userService;

    @RequestMapping("/user/{pageIndex}")
    public String queryAll(Map<String,Object> map, @PathVariable("pageIndex") Integer pageIndex){
        Page<Object> startPage = null;
        if(pageIndex != null || pageIndex == 0 ){
            startPage = PageHelper.startPage(pageIndex, 2);
        }else {
            startPage = PageHelper.startPage(1,2);
        }

        List<User> users = userService.queryAll();
        int pages = startPage.getPages();
        map.put("users",users);
        map.put("pages",pages);
        logger.info(users.toString());


        return DOWN;
    }
}
