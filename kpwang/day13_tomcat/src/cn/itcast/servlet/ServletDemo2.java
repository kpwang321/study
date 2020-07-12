package cn.itcast.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author kpwang
 * @create 2020-07-02 18:49
 */
public class ServletDemo2 implements Servlet {
    /*
    * 初始化方法，在servlet被创建时执行，只会执行一次
    * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init............");
    }


    /*
    * 在servlet每一次被访问时都会执行，执行多次
    * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service............");
    }


    /*
    * 销毁方法
    * 在服务器正常关闭时，执行，执行一次
    * */
    @Override
    public void destroy() {
        System.out.println("destroy..........");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    /*
    *
    * */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
}
