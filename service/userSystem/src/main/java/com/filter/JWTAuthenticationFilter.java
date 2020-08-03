//package com.filter;
//
//import com.util.JwtUtils;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by lenovo
// * Date 2020/7/27 13:56
// */
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private AuthenticationManager authenticationManager;
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//        super.setFilterProcessesUrl("/auth/login");
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request,
//                                                HttpServletResponse response) throws AuthenticationException {
//
//        // 从输入流中获取到登录的信息
//        return authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken("111", "222")
//        );
//    }
//
//    // 成功验证后调用的方法
//    // 如果验证成功，就生成token并返回
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//
//
//
//        String token = JwtUtils.createToken("111", "222");
//        //String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
//        // 返回创建成功的token
//        // 但是这里创建的token只是单纯的token
//        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        String tokenStr = JwtUtils.TOKEN_PREFIX + token;
//        response.setHeader("token",tokenStr);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
//    }
//}
