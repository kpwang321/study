package cn.itcast.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kpwang
 * @create 2020-07-03 17:20
 */
@WebServlet( "/ServletCookieDemo3")
public class ServletCookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1=new Cookie("msg","hello");
        Cookie cookie2=new Cookie("name","zhaoliying");
        Cookie cookie3=new Cookie("name","赵丽颖");

        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
