package com.filter;

import com.core.service.RedefinedUserDetailService;
import com.util.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo
 * Date 2020/7/27 16:00
 */
@Component
public class XWAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    RedefinedUserDetailService redefinedUserDetailService;


    /**
     * 获取验证token中的身份信息
     * @author xuwang
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //从请求头中获取token
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            //从token中获取用户名
            String username = JwtUtils.getUsername(authHeader);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = redefinedUserDetailService.loadUserByUsername(username);
                if (JwtUtils.validateToken(authHeader, userDetails)) {
                    //token中的用户信息和数据库中的用户信息对比成功后将用户信息加入SecurityContextHolder相当于登陆
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }

}
