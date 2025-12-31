package com.vnr.springsecuritydemo.controllers;


import com.vnr.springsecuritydemo.dto.LoginRequest;
import com.vnr.springsecuritydemo.dto.RegisterRequest;
import com.vnr.springsecuritydemo.service.AuthenticationProviderService;
import com.vnr.springsecuritydemo.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationProviderService authenticateionProviderService;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder, AuthenticationProviderService authenticateionProviderService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.authenticateionProviderService = authenticateionProviderService;
    }


    @GetMapping("/main")
    public String dashboard(Authentication authentication) {
        return "Login successful for user: " + authentication.getName();
    }

    @GetMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        Authentication authentication = authenticateionProviderService.authenticate(
                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                        request.userName(), request.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);


        return "Login successful for user: " + request.userName();
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        userService.saveUser(request.userName(), request.password());
        return "User registered successfully: " + request.userName();
    }

}
