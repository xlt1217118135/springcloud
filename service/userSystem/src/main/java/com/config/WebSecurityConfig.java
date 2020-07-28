package com.config;

import com.core.service.RedefinedUserDetailService;
import com.filter.XWAuthenticationTokenFilter;
import com.handle.EntryPointUnauthorizedHandler;
import com.handle.RestAccessDeniedHandler;
import com.security.DefinedAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Created by lenovo
 * Date 2020/7/27 14:48
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RedefinedUserDetailService redefinedUserDetailService;

    @Resource
    private XWAuthenticationTokenFilter xwAuthenticationTokenFilter;
    @Resource
    private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;
    @Resource
    private RestAccessDeniedHandler restAccessDeniedHandler;

    /**
     * 注入UserAuthenticationProvider
     * @return
     */
    @Bean("definedAuthenticationProvider")
    DaoAuthenticationProvider daoUserAuthenticationProvider(){
        return new DefinedAuthenticationProvider(encoder(), redefinedUserDetailService);
    }

    /**
     * 向AuthenticationManager添加Provider
     * @return
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(daoUserAuthenticationProvider());
    }


    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(this.redefinedUserDetailService).passwordEncoder(encoder());
    }

    /**
     * 注入AuthenticationManager
     * @return
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 注入PasswordEncoder
     * @return
     */
    @Bean
    public PasswordEncoder encoder() {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }


    /**
     * 具体Security 配置
     * @return
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().//默认开启，这里先显式关闭csrf
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Spring Security永远不会创建HttpSession，它不会使用HttpSession来获取SecurityContext
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/login/logining").permitAll() //此处存放不拦截的方法请求
                .antMatchers("/login.html",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/swagger-resources/**",
                        "/v2/**",
                        "csrf"
                ).permitAll() //任何用户可以访问/user/**
                .anyRequest().authenticated() //任何没有匹配上的其他的url请求，只需要用户被验证
                .and()
                .headers().cacheControl();
        http.addFilterBefore(xwAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().authenticationEntryPoint(entryPointUnauthorizedHandler).accessDeniedHandler(restAccessDeniedHandler);
    }


}
