package com.pms.pharmacymanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // As requested, using NoOpPasswordEncoder for plain text passwords.
        // This is not recommended for production environments.
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Publicly accessible URLs
                        .requestMatchers(
                                new AntPathRequestMatcher("/"),
                                new AntPathRequestMatcher("/login"),
                                new AntPathRequestMatcher("/css/**"),
                                new AntPathRequestMatcher("/js/**")
                        ).permitAll()
                        // Owner-specific URLs for finance and administration
                        .requestMatchers(
                                new AntPathRequestMatcher("/owner/**"),
                                new AntPathRequestMatcher("/finance/**"),
                                new AntPathRequestMatcher("/admin/**")
                        ).hasRole("OWNER")
                        // Staff-specific URLs
                        .requestMatchers(new AntPathRequestMatcher("/staff/**")).hasAnyRole("OWNER", "STAFF")
                        // Any other request must be authenticated
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/", true)
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login?logout")
                                .permitAll()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}