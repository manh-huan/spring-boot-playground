package com.vnr.springsecuritydemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class UserManagementConfig {



    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        //Build user with a username, password, and authority


        //Add user to be managed by UserDetailsService


        return userDetailsService;

    }
}
