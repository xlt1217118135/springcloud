package com.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by lenovo
 * Date 2020/7/30 16:35
 */
public class TestMain {

    public static void main(String[] arhs){
        String str = "222";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密"0"
        String encode = bCryptPasswordEncoder.encode(str);
        System.out.println(encode);
    }
}
