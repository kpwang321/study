package com.itheima.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kpwang
 * @create 2020-07-11 17:13
 */
@RestController
public class Quick2Controller {

    @Value("${name}")
    private String name;
    @Value("${person.addr}")
    private String addr;
    @RequestMapping("/quick2")
    public String quick2(){

        System.out.println(name);
        System.out.println(addr);
        return "name:"+name;
    }
}
