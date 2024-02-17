package com.photoalbum.dodo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



@Component
public class LogInterceptor implements HandlerInterceptor {
    private static final String START_TIME = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute(START_TIME, startTime);
        if (request.getSession().getAttribute("loggedInMember") == null) {
            String requestURI = request.getRequestURI();
            System.out.println(requestURI);
            // 檢查是否是index頁面或登入頁面
            if (!requestURI.endsWith("/home") && !requestURI.endsWith("/login")) {
                // 如果不是，且用戶未登入，則重定向到登入頁面
                response.sendRedirect(request.getContextPath() + "/login");
                return false; // 中斷後續攔截器的執行
            }
        }

        // 如果已經登入，則繼續執行後續的攔截器或請求處理
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long startTime = (Long) request.getAttribute(START_TIME);
        if (startTime != null) {
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - startTime;
            String executeTimeSeconds = String.format("%.5f", executeTime / 1000.0);
            System.out.println("請求處理時間：" + executeTimeSeconds + "秒");
        } else {
            System.out.println("請求開始時間未設定，無法計算處理時間。");
        }
    }

}
