package com.vnr.springsecuritydemo.config;


import com.vnr.springsecuritydemo.service.AuthenticationProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
public class WebAuthorizationConfig {

    //add security filter chain bean to configure authorization rules with HttpSecurity
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/**").permitAll()
                        .requestMatchers("/api/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .authenticationProvider(
                        new AuthenticationProviderService()
                );
        return http.build();
    }

}
