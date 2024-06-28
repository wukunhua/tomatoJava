//package com.example.toamto.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http
//                // 配置授权请求规则
//                .authorizeRequests()
//                // 任何请求都需要认证
//                .anyRequest()
//                .authenticated()
//                // 使用and()方法连接多个配置
//                .and()
//                // 开启HTTP基本认证功能
//                .httpBasic();
//        return http.build();
//    }
//}
