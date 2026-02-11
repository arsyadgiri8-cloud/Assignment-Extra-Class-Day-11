package com.Assignment.Day._7.service;


import com.Assignment.Day._7.dto.LoginRequest;
import com.Assignment.Day._7.dto.RegisterRequest;
import com.Assignment.Day._7.entity.User;
import com.Assignment.Day._7.repository.UserRepository;
import com.Assignment.Day._7.security.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    UserRepository repo;

    @Mock
    PasswordEncoder encoder;

    @Mock
    JwtUtil jwtUtil;

    @InjectMocks
    AuthService service;

    @Test
    void register_success() {
        RegisterRequest req = new RegisterRequest();
        req.setUsername("test");
        req.setPassword("123");

        when(encoder.encode(any())).thenReturn("hashed");

        service.register(req);

        verify(repo).save(any());
    }

    @Test
    void login_success_whenValidCredential() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("hashed");
        user.setRole("USER");

        LoginRequest req = new LoginRequest();
        req.setUsername("test");
        req.setPassword("123");

        when(repo.findByUsername("test")).thenReturn(Optional.of(user));
        when(encoder.matches(any(), any())).thenReturn(true);
        when(jwtUtil.generateToken(any(), any())).thenReturn("token");

        String token = service.login(req);

        assertEquals("token", token);
    }

    @Test
    void login_throwException_whenPasswordWrong() {
        User user = new User();
        user.setPassword("hashed");

        LoginRequest req = new LoginRequest();
        req.setUsername("test");
        req.setPassword("wrong");

        when(repo.findByUsername(any())).thenReturn(Optional.of(user));
        when(encoder.matches(any(), any())).thenReturn(false);

        assertThrows(RuntimeException.class, () -> service.login(req));
    }

}
