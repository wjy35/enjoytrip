package com.ssafy.enjoytrip.jwt.model.interceptor;

import com.ssafy.enjoytrip.jwt.model.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private JwtService jwtService;
    private static final String HEADER_AUTH = "auth-token";

    @Autowired
    public JwtInterceptor(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String token = request.getHeader(HEADER_AUTH);

        if(token != null && jwtService.checkValidToken(token)){
            return true;
        }

        throw new RuntimeException();
    }
}
