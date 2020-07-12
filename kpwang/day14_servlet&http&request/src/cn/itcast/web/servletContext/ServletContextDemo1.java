package cn.itcast.web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kpwang
 * @create 2020-07-03 3:40
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context1 = req.getServletContext();


        ServletContext context2 = this.getServletContext();
        System.out.println(context1==context2);
        System.out.println(context1);
        System.out.println(context2);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
