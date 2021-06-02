package com.cong.blog.Interceptor;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.cong.Utils.JsonUtil;
import com.cong.Utils.JwtUtil;
import com.cong.Utils.Result;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtIterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,DELETE,PUT");
        String token = request.getHeader("Authorization");
        Result res;
        try {
            JwtUtil.verify(token);
            return true;
        } catch (TokenExpiredException e) {
            res = Result.create(400, "登录过期");
        } catch (Exception e) {
            e.printStackTrace();
            res = Result.create(401, "无效token");
        }
        String json = JsonUtil.getJson(res);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
