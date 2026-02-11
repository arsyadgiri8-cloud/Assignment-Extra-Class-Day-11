package com.Assignment.Day._7.service;

import com.Assignment.Day._7.dto.LoginRequest;
import com.Assignment.Day._7.dto.RegisterRequest;
import com.Assignment.Day._7.entity.User;
import com.Assignment.Day._7.repository.UserRepository;
import com.Assignment.Day._7.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepo, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public void register(RegisterRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setRole("USER");
        userRepo.save(user);
    }

    public String login(LoginRequest req) {
        User user = userRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Password salah");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }
}

