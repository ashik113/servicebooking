package com.ashik.servicebooking.config;

import com.ashik.servicebooking.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // disable csrf
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/auth/*")
                        .permitAll()
                        .requestMatchers("/api/test").permitAll().anyRequest().authenticated() // allow all requests
                ).addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
