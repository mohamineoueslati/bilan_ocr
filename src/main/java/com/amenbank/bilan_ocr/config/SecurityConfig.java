package com.amenbank.bilan_ocr.config;

import com.amenbank.bilan_ocr.filter.JwtAuthFilter;
import com.amenbank.bilan_ocr.filter.UsernamePasswordAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthFilter jwtAuthFilter;

    @Autowired
    public SecurityConfig(AuthenticationProvider authenticationProvider, JwtAuthFilter jwtAuthFilter) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterAt(usernamePasswordAuthFilter(), BasicAuthenticationFilter.class);
        http.addFilterAfter(jwtAuthFilter, BasicAuthenticationFilter.class);

        http.authorizeRequests().antMatchers("/swagger/**").permitAll();
        http.authorizeRequests().antMatchers("/api/users/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/api/bilans/**").authenticated();
    }

    private UsernamePasswordAuthFilter usernamePasswordAuthFilter() throws Exception {
        return new UsernamePasswordAuthFilter(authenticationManager());
    }
}
