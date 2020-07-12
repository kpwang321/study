package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kpwang
 * @create 2020-07-09 21:14
 */
@Controller
@RequestMapping("/user")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("hello stringmvc");
        return "success";
    }
    @RequestMapping(value = "/testRequestMapping",method = RequestMethod.POST)
    public String testRequestMapping(){
        System.out.println("测试requestMapping注解。。。");
        return "success";
    }
}
