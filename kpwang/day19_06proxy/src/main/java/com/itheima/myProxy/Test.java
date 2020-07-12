package com.itheima.myProxy;

import java.lang.reflect.Proxy;

/**
 * @author kpwang
 * @create 2020-07-11 2:17
 */
public class Test {
    public static void main(String[] args) {
        Rent rent = new Landlord();
        Intermediary intermediary = new Intermediary(rent);
        Rent rentProxy = (Rent) Proxy.newProxyInstance(rent.getClass().getClassLoader(), rent.getClass().getInterfaces(), intermediary);
        rentProxy.rent();
    }
}
