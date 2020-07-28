package com.core.controller;

import com.core.service.RedefinedUserDetailService;
import com.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lenovo
 * Date 2020/7/27 14:16
 */
@Controller
@RequestMapping("login")
@Api
public class LoginController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedefinedUserDetailService redefinedUserDetailService;

    @GetMapping("logining")
    @ResponseBody
    @ApiOperation("登陆")
    public String logining(){

        //不同的用户类型使用不同的登陆方式
        String token = "";
        UserDetails userDetails = null;
        login(new UsernamePasswordAuthenticationToken("111", "222"));
        userDetails = redefinedUserDetailService.loadUserByUsername("111");
        token = JwtUtils.createToken("111", "222");

        return token;
    }

    /**
     * 校验账号密码并进行登陆
     * @param upToken
     */
    private void login(UsernamePasswordAuthenticationToken upToken){
        //验证
        Authentication authentication = authenticationManager.authenticate(upToken);
        //将用户信息保存到SecurityContextHolder=登陆
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
