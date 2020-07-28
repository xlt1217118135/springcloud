package com.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo
 * Date 2020/7/27 16:46
 */
@Controller
@RequestMapping("/home")
@Api
public class HomeController {

    @GetMapping("test")
    @ResponseBody
    @ApiOperation("权限通过")
    public String test(){
        return "111";
    }
}
