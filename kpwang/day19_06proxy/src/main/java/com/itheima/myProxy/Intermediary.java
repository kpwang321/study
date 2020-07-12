package com.itheima.myProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author kpwang
 * @create 2020-07-11 2:16
 */
public class Intermediary implements InvocationHandler {
    private Object post;

    Intermediary(Object post){
        this.post = post;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(post, args);
        System.out.println("中介：该房源已发布！");
        return invoke;
    }
}
