package com.aranna.solution_1_nimbuse_jose_jwt.security.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthConfiguration {
    public static final Logger log = LoggerFactory.getLogger(BasicAuthConfiguration.class);
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity.authorizeHttpRequests(
                customizer -> customizer
                        .requestMatchers( "/user/signup",
                                "/user/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(customizer -> customizer.disable())
                .formLogin(customizer -> customizer.disable())
                .oauth2ResourceServer(customizer -> customizer.jwt(Customizer.withDefaults()))
                .build();
    }
}
