package com.Assignment.Day._7.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

   @Override
protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response,
                                FilterChain chain)
        throws IOException, jakarta.servlet.ServletException {

    String path = request.getServletPath();

    // Skip auth endpoint
    if (path.startsWith("/api/auth")) {
        chain.doFilter(request, response);
        return;
    }

    String header = request.getHeader("Authorization");

    // Kalau tidak ada Authorization → lanjut aja
    if (header == null || !header.startsWith("Bearer ")) {
        chain.doFilter(request, response);
        return;
    }

    String token = header.substring(7).trim();

    // Extra safety
    if (token.isEmpty()) {
        chain.doFilter(request, response);
        return;
    }

    jwtUtil.extractUsername(token);

    chain.doFilter(request, response);
}

}
