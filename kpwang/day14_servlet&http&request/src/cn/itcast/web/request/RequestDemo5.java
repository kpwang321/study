package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author kpwang
 * @create 2020-07-03 0:59
 */
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息体--请求参数
        /*BufferedReader reader = request.getReader();
        String line=null;
        System.out.println("-----");*/
       /* while ((line=reader.readLine())!=null){
            System.out.println(line);
        }*/
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String, String[]> map = request.getParameterMap();
        Set<String> strings = map.keySet();
        for (String string : strings) {
            String[] str = map.get(string);
            for (String s : str) {
                System.out.println(string+s);
            }

        }


        System.out.println("username:"+username+"-------password"+password);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--------");
        doPost(request,response);
    }
}
