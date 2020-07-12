package com.itheima.jdbc;

import java.sql.*;

/**
 * @author kpwang
 * @create 2020-07-07 1:16
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");//编译器不依赖，运行时依赖。就是解耦
        //2获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.5.106:33306/spring?characterEncoding=utf-8", "root", "root");
        //3获取操作数据库的预处理对象
        PreparedStatement pst=conn.prepareStatement("select * from account");
        //4执行SQL，得到结果集
        ResultSet resultSet = pst.executeQuery();

        //5遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        //6释放资源
        resultSet.close();
        pst.close();
        conn.close();

    }
}
