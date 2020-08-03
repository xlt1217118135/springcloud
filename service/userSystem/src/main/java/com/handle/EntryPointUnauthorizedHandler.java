//package com.handle;
//
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.AuthenticationException;
//
///**
// * Created by lenovo
// * Date 2020/7/27 16:09
// */
//@Component
//public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//        httpServletResponse.setStatus(401);
//        httpServletResponse.sendRedirect("/login.html");
//    }
//}
