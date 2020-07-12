package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kpwang
 * @create 2020-07-10 20:19
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        //获取异常对象
        SysException e=null;
        if (ex instanceof SysException){
            e=(SysException) ex;
        }else {
            e=new SysException("系统正在维护.....");
        }
        //
        ModelAndView mav=new ModelAndView();
        mav.addObject("errorMsg",e.getMessage());
        mav.setViewName("error");
        return mav;
    }
}
