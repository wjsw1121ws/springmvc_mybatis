package com.cc.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @ClassName: CustomerExceptionResolver
 * @Auther: changchun_wu
 * @Date: 2018/12/1 22:36
 * @Version: 1.0
 **/
public class CustomerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) {
        ModelAndView mav = new ModelAndView();
        if (e instanceof MessageException){
            mav.addObject("error",((MessageException) e).getMsg());
        }
        else {
            mav.addObject("error","未知异常");
        }
        mav.setViewName("/jsp/error");
        return mav;
    }
}
