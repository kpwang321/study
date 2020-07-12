package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kpwang
 * @create 2020-07-02 21:15
 */
//@WebServlet({"/d4","/dd4","/ddd4"})
@WebServlet("*.do")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost....");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGetdemo4......");
        System.out.println(request.getMethod());//获取请求方式
        System.out.println(request.getContextPath());//获取虚拟目录
        System.out.println(request.getServletPath());//获取servlet路径
        System.out.println(request.getQueryString());
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRemoteAddr());

        System.out.println(request.getHeader("Accept"));
        System.out.println(request.getHeaderNames());

    }
}
