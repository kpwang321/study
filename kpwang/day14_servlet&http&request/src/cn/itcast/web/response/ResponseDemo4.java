package cn.itcast.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kpwang
 * @create 2020-07-03 2:17
 */
@WebServlet("/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置默认编码：ISO-8859-1  置为GBK或者utf-8
        //response.setHeader("content-type","text/html;charset=utf-8");

        //简单的形式设置编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter writer = response.getWriter();
        writer.write("hello response");
        //中文乱码   浏览器默认编码是 GBK(GB2312)    流是tomcat的获取的，tomcat是ISO-8859-1

        writer.write("你好啊f response");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
