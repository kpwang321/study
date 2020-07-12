package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author kpwang
 * @create 2020-07-08 17:55
 */
public class Logger {
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了");
    }
    public void afterReturnPrintLog(){
        System.out.println("后置通知Logger类中的afterReturnPrintLog方法开始记录日志了");
    }
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了");
    }
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了");
    }
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args=pjp.getArgs();
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了1");
            rtValue = pjp.proceed(args);//明确调用业务层方法

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了2");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了3");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了4");
        }

    }
}
