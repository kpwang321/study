package com.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kpwang
 * @create 2020-07-11 14:59
 */
@RestController
public class QuickController {
    @RequestMapping("/quick")
    public String quick(){
        return "spring boot";
    }
}
