package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author kpwang
 * @create 2020-07-11 14:06
 */

@SpringBootApplication//声明该类是一个springboot引导类
public class MySpringBootApplication {
    //main是java程序的入口
    public static void main(String[] args) {
        //run方法表示运行springboot的引导类  run参数就是springboot引导类的字节码对象
        SpringApplication.run(MySpringBootApplication.class);
    }
}
