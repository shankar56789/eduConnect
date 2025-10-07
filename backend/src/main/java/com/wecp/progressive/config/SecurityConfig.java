package com.wecp.progressive.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.wecp.progressive.jwt.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder,
                          JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    // Configure authentication manager with UserDetailsService + PasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
    }

    // Configure HTTP security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors() // Enable CORS
            .and()
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            // Disable CSRF for JWT-based authentication
            .authorizeRequests()
                .antMatchers("/auth/**").permitAll() // Public endpoints (e.g., login, register)
                .antMatchers("/attendance/**").hasAuthority("TEACHER")
                .antMatchers(HttpMethod.GET,"/attendance/**").hasAuthority("STUDENT")

                .antMatchers("/course/**").hasAnyAuthority("TEACHER")
                .antMatchers(HttpMethod.GET,"/course/**").hasAuthority("STUDENT")

                .antMatchers("/enrollment").hasAuthority("TEACHER")
                .antMatchers(HttpMethod.GET,"/enrollment/**").hasAuthority("STUDENT")

                //.antMatchers("/admin/**").hasRole("ADMIN")
                 // Role-based access
                 .antMatchers("/student/**").hasAuthority("STUDENT")
                 .antMatchers("/teacher/**").hasAnyAuthority("TEACHER")
                .anyRequest().authenticated() // All other endpoints require authentication
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // No sessions (JWT)

        // Add JWT filter before UsernamePasswordAuthenticationFilter
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    // Expose AuthenticationManager bean
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
