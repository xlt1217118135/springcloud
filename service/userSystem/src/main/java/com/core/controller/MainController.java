package com.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lenovo
 * Date 2020/7/30 15:31
 */
@Controller
@RequestMapping("mainlogin")
public class MainController {

    @GetMapping("test")
    @ResponseBody
    public String test(){
        return "222";
    }
}
