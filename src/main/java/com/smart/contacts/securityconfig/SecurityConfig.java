package com.smart.contacts.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.smart.contacts.service.implementation.SecurityCustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final SecurityCustomUserDetailsService securityCustomUserDetailsService;

    public SecurityConfig(SecurityCustomUserDetailsService securityCustomUserDetailsService) {
        this.securityCustomUserDetailsService = securityCustomUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(securityCustomUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeHttpRequests(authorize -> {
                authorize
                    .requestMatchers("/home", "/register", "/services", "/about").permitAll()
                    .requestMatchers("/user/**").authenticated()
                    .anyRequest().permitAll();
            });
            
        httpSecurity.formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
