package com.amenbank.bilan_ocr.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class UsernamePasswordAuthFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final String signingKey = "ymLTU8rq83j4fmJZj60wh4OrMNuntIj4fmJ";
    private final SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));

    public UsernamePasswordAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null) {
            var auth = new UsernamePasswordAuthenticationToken(
                    username,
                    password
            );

            return authenticationManager.authenticate(auth);
        } else {
            throw new AuthenticationCredentialsNotFoundException("Username and password are required to authenticate");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
        var username = authResult.getName();
        var authorities = authResult.getAuthorities();

        var token = Jwts.builder()
                .setSubject(username)
                .addClaims(Map.of("role", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())))
                .setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                .setIssuer(request.getRequestURI())
                .signWith(key)
                .compact();

        response.setHeader("Authorization", token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
