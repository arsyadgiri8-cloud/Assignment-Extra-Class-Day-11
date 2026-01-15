package com.Assignment.Day._7.controller;

import com.Assignment.Day._7.dto.ApiResponse;
import com.Assignment.Day._7.dto.LoginRequest;
import com.Assignment.Day._7.dto.RegisterRequest;
import com.Assignment.Day._7.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ApiResponse<?> register(@RequestBody RegisterRequest req) {
        service.register(req);
        return new ApiResponse<>(true, "Registrasi berhasil", null);
    }

    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody LoginRequest req) {
        String token = service.login(req);
        return new ApiResponse<>(true, "Login berhasil", token);
    }
}
