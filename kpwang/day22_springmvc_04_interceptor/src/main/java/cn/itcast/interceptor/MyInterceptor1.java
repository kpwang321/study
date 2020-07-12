package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kpwang
 * @create 2020-07-10 21:17
 */
public class MyInterceptor1 implements HandlerInterceptor{

    //预处理，contorller方法执行前
    //return true 放行，执行下一个拦截器，如果没有下一个拦截器，执行controller方法
    //return false不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("myInterceptor1执行了.......前111");
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return true;
    }
    //后处理   controller方法执行会，success.jsp执行前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("myInterceptor1执行了.......后111");
    }
    //success.jsp页面执行后，该方法执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("myInterceptor1执行了.......最后111");
    }
}
