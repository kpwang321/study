package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kpwang
 * @create 2020-07-08 3:27
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //开启事务
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //提交事务
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //回滚事务
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //释放连接
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
