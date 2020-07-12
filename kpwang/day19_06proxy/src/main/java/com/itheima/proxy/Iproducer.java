package com.itheima.proxy;

/**
 * @author kpwang
 * @create 2020-07-08 16:01
 */
public interface Iproducer {
    //销售
    public void saleProduct(Float money);

    //售后
    public void afterService(float money);
}
