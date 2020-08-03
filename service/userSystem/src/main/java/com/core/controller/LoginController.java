package com.core.controller;

import com.core.entity.User;
import com.redis.RedisTempletUtil;
import com.util.CommonConstance;
import com.util.HttpCodeAndMessage;
import com.util.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo
 * Date 2020/7/27 14:16
 */
@Controller
@RequestMapping("login")
@Api
public class LoginController {

    @Autowired
    private RedisTempletUtil redisTempletUtil;

    @GetMapping("logining")
    @ResponseBody
    @ApiOperation("登陆")
    public ResponseWrapper logining(){

        ResponseWrapper responseWrapper = new ResponseWrapper();

//        //不同的用户类型使用不同的登陆方式
//        String token = "";
//        UserDetails userDetails = null;
//        login(new UsernamePasswordAuthenticationToken("111", "222"));
//        userDetails = redefinedUserDetailService.loadUserByUsername("111");
//        token = JwtUtils.createToken("111", "222");
        try{
            User user = new User();
            Thread.sleep(5500);
            Long key = 111111L;
            user.setUserId(key);
            user.setUserName("用户1");

            redisTempletUtil.setDataForExpire(key.toString(), user, CommonConstance.REDIS_EXPIRE_TIME);

            responseWrapper.setStatus(true);
            responseWrapper.setCode(HttpCodeAndMessage.OK.getCode());
            responseWrapper.setMessage(HttpCodeAndMessage.OK.getMessage());
        }catch( Exception e){
            e.printStackTrace();
        }


        return responseWrapper;
    }

    @GetMapping("loginOut")
    @ResponseBody
    public ResponseWrapper loginOut(){

        String key = "111";
        redisTempletUtil.deleteData(key);

        ResponseWrapper responseWrapper = new ResponseWrapper();

        responseWrapper.setStatus(true);
        responseWrapper.setCode(HttpCodeAndMessage.OK.getCode());
        responseWrapper.setMessage(HttpCodeAndMessage.OK.getMessage());

        return responseWrapper;

    }
}
