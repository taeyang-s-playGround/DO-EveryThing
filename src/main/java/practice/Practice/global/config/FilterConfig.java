package practice.Practice.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import practice.Practice.global.error.GlobalExceptionFilter;
import practice.Practice.global.security.jwt.JwtTokenFilter;
import practice.Practice.global.security.jwt.JwtTokenProvider;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity http) {

        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);

        GlobalExceptionFilter globalExceptionFilter = new GlobalExceptionFilter(objectMapper);

        http.addFilterBefore(globalExceptionFilter, UsernamePasswordAuthenticationFilter.class);
    }
}