package com.affiliate.app.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableReactiveMethodSecurity
public class SecurityConfig {




//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        return http
//            .csrf(csrf -> csrf.disable())
//            .authorizeExchange(auth -> auth
//                .pathMatchers("/api/**").permitAll()
//              .pathMatchers("/api/user/**").hasAuthority("ROLE_USER")
//            .pathMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")
//                .anyExchange().authenticated()
//            )
////             JwtAuthFilter is a @Component WebFilter and will be picked up automatically
//            .build();
//
//    }

    @//@Bean
//public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//    return http.getSharedObject(AuthenticationManagerBuilder.class)
//            .build();
//}
Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//@Bean
//public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//    return http.getSharedObject(AuthenticationManagerBuilder.class)
//            .build();
//}

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new MapReactiveUserDetailsService(user);
    }



}
