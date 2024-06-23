package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // HTTP 보안 설정을 구성합니다.
        http
            .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/h2-console/**").permitAll() // h2-console 경로는 모든 접근을 허용
                .anyRequest().permitAll() // 다른 모든 요청도 허용
            )
            .headers(headers -> headers.frameOptions(options -> options.sameOrigin())); // FrameOptions 설정

        return http.build();
    }
}
