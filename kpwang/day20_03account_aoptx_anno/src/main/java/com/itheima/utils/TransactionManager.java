package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kpwang
 * @create 2020-07-08 3:27
 */
@Component("txManager")
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pt1(){

    }
    //开启事务
    private void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //提交事务
    private void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //回滚事务
    private void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //释放连接
    private void release(){
        try {
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args = pjp.getArgs();
            this.beginTransaction();
            rtValue=pjp.proceed(args);
            this.commit();
            return rtValue;
        } catch (Throwable throwable) {
            this.rollback();
            throw new RuntimeException(throwable);
        } finally {
            this.release();
        }
    }
}
