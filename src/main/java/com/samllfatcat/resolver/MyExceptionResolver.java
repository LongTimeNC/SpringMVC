package com.samllfatcat.resolver;

import com.samllfatcat.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zsz
 * @Description
 * @date 2022/6/9
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        //参数Exception：异常对象
        //返回值ModelAndView：跳转的视图信息
        if(ex instanceof MyException){
            modelAndView.addObject("info","自定义的异常。。。");
            //判断异常的类型跳转具体的异常页面
            modelAndView.setViewName("error2");
        }else if(ex instanceof ClassCastException){
            modelAndView.addObject("info","类型转换的异常。。。");
            //判断异常的类型跳转具体的异常页面
            modelAndView.setViewName("error3");
        }else {
            modelAndView.setViewName("success");
        }
        return modelAndView;
    }
}
