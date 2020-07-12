package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kpwang
 * @create 2020-07-11 14:19
 */
@Controller
public class QuickController {
    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "nihao springboot";
    }
}
