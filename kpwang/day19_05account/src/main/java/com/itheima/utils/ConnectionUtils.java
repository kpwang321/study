package com.itheima.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kpwang
 * @create 2020-07-08 3:19
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //获取当前线程上的连接
    public Connection getThreadConnection(){
        //1先从ThreadLocal上获取
        Connection connection = tl.get();
        //2判断当前线程上是否有连接
        if (connection==null){
            //3从数据源中获取一个连接，并且和线程绑定(存入Threadlocal)
            try {
                connection=dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            tl.set(connection);
            //
        }
        //4返回当前线程上的连接
        return connection;

    }
    //把连接和线程解绑
    public void removeConnection(){
        tl.remove();
    }
}
