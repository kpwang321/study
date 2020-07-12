package com.itheima.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kpwang
 * @create 2020-07-11 17:13
 */
@RestController
@ConfigurationProperties(prefix = "person")
public class Quick3Controller {


    private String name;
    private String addr;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @RequestMapping("/quick3")
    public String quick2(){

        System.out.println(name);
        System.out.println(addr);
        return "name:"+name;
    }
}
