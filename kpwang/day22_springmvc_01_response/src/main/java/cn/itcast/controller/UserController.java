package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kpwang
 * @create 2020-07-10 15:58
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了。。");

        User user=new User();
        user.setUsername("李沁");
        user.setPassword("123");
        user.setAge(27);
        model.addAttribute("user",user);
        return "success";
    }
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了。。");
        //编写请求转发的程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //直接会进行响应
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("李沁");

        return;
    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView()  {
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("testModelAndView执行了。。");

        User user=new User();
        user.setUsername("李沁");
        user.setPassword("123");
        user.setAge(27);
        modelAndView.addObject("user" ,user);
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect()  {
        System.out.println("testForwardOrRedirect执行了。。");
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }
    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User user)  {
        System.out.println("testAjax执行了。。");
        System.out.println(user);


        user.setPassword("abc123");
        user.setAge(29);
        return user;
    }
}
