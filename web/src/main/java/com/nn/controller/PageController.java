package com.nn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    private static final String TOP = "top"; // top.jsp
    private static final String LEFT = "left"; // left.jsp
    private static final String RIGHT = "right"; // right.jsp
    private static final String DOWN = "down"; // down.jsp


    @RequestMapping("/top")
    private String top(){
        return TOP;
    }

    @RequestMapping("/left")
    private String left(){
        return LEFT;
    }

    @RequestMapping("/right")
    private String right(){
        return RIGHT;
    }

    @RequestMapping("/down")
    private String down(){
        return DOWN;
    }
}
