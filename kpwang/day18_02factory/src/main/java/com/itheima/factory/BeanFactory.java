package com.itheima.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author kpwang
 * @create 2020-07-07 1:55
 *
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties props;
    //定义一个Map，用于存放我们要创建的对象。称之为容器
    private static Map<String ,Object> beans;

    //使用静态代码块为properties对象赋值
    //
    static {
        try {
            props=new Properties();
            InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beans=new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                String key=keys.nextElement().toString();
                String beanPath=props.getProperty(key);
                Object value=Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
/*    public static Object getBean(String beanName){
        Object bean=null;
        try {
            String beanPath=props.getProperty(beanName);
            //System.out.println(beanPath);
            bean=Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
