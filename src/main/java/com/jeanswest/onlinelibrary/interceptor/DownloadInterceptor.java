package com.jeanswest.onlinelibrary.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.jeanswest.onlinelibrary.entity.ResultData;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author :肖钊容
 * @date :2019-07-02 14:35
 * @description :下载图书拦截器
 */
public class DownloadInterceptor extends HandlerInterceptorAdapter {
    private final String POST = "POST";
    private String authorization = "";

    /**
     * 拦截器拦截前处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        authorization = request.getHeader("Authorization");
        if (POST.equals(request.getMethod())) {
            if (null != request.getSession().getAttribute(authorization)) {
                return true;
            } else {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write(JSONObject.toJSONString(ResultData.warn("请登录")));
                out.flush();
                out.close();
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * 拦截后处理
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 全部完成后处理
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
