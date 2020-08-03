//package com.security;
//
//import com.core.service.RedefinedUserDetailService;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.userdetails.UserDetailsPasswordService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * Created by lenovo
// * Date 2020/7/27 15:53
// */
//public class DefinedAuthenticationProvider extends DaoAuthenticationProvider {
//
//    /**
//     * 初始化 将使用Manager专用的userDetailsService
//     * @param encoder
//     * @param userDetailsService
//     */
//    public DefinedAuthenticationProvider(PasswordEncoder encoder, RedefinedUserDetailService userDetailsService){
//        setPasswordEncoder(encoder);
//        setUserDetailsService(userDetailsService);
//    }
//
//    @Override
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        super.setPasswordEncoder(passwordEncoder);
//    }
//
//    @Override
//    public void setUserDetailsPasswordService(UserDetailsPasswordService userDetailsPasswordService) {
//        super.setUserDetailsPasswordService(userDetailsPasswordService);
//    }
//
////    /**
////     * 判断只有传入ManagerAuthenticationToken的时候才使用这个Provider
////     * supports会在AuthenticationManager层被调用
////     * @param authentication
////     * @return
////     */
////    public boolean supports(Class<?> authentication) {
////        return ttrue;
////    }
//}
