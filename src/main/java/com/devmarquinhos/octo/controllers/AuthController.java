package com.devmarquinhos.octo.controllers;

import com.devmarquinhos.octo.dto.LoginRequest;
import com.devmarquinhos.octo.dto.LoginResponse;
import com.devmarquinhos.octo.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.auth(request);
    }
}
