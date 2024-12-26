package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.controller.exchanges.request.AuthRequest;
import com.nt.controller.exchanges.request.RegisterRequest;
import com.nt.controller.exchanges.response.AuthResponse;
import com.nt.service.AuthService;

@Controller
public class AuthController {

    @Autowired
   private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {
           return ResponseEntity.ok(authService.login(request));
    }
}
