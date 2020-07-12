package cn.itcast.controller;

import cn.itcast.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kpwang
 * @create 2020-07-10 20:08
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException执行了。。。。。。。");

        try {
            int i=1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询用户出现错误");
        }

        return "success";
    }
}
