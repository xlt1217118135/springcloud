//package com.core.service;
//
//import com.core.entity.RedefinitionUserDetail;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * Created by lenovo
// * Date 2020/7/27 15:33
// */
//@Service
//public class RedefinedUserDetailService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//
//        RedefinitionUserDetail userDetails = new RedefinitionUserDetail();
//        userDetails.setUserId("111");
//        userDetails.setUsername("111");
//        userDetails.setPassword("$2a$10$cnHyes76F2yeitQ3NiBWHOYZHpbyHuVJ3JZsZMUrMpTVkrnWcCeGS");
//        return userDetails;
//    }
//}
