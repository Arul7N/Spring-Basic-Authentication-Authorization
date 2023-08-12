package com.example.SecurityApp.Configuration;

import com.example.SecurityApp.Service.InfoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFltrChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/","/add").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/**").authenticated()
                .and()
                .formLogin();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails arul = User.builder()
//                .username("arul")
//                .password(encoder().encode("user"))
//                .roles("USER")
//                .build();
//
//        UserDetails nilavan = User.builder()
//                .username("nilavan")
//                .password(encoder().encode("admin"))
//                .roles("ADMIN")
//                .build();

        return new InfoUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(encoder());
        return authenticationProvider;
    }
}
