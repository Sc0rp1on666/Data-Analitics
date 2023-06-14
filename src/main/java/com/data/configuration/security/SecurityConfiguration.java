//package com.data.configuration.security;
//
//import com.data.service.security.CustomUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration{
//    private final JwtTokenProvider jwtTokenProvider;
//    private final CustomUserDetailsService customUserDetailsService;
//
//    public SecurityConfiguration(JwtTokenProvider jwtTokenProvider, CustomUserDetailsService customUserDetailsService) {
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.customUserDetailsService = customUserDetailsService;
//    }
//    @Bean
//    public JwtTokenFilter jwtTokenFilter(){
//        return new JwtTokenFilter(jwtTokenProvider);
//    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(customUserDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return  authenticationProvider;
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
//        return http.getSharedObject(AuthenticationManagerBuilder.class).authenticationProvider(authenticationProvider()).build();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.csrf().disable()
//                .cors().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user**").permitAll()
//                .antMatchers("/auth**").permitAll()
//                //TODO: add form login once it will be done, for now make an authorize controller, get rid of WebSecurityAdapter
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
//                http.authenticationProvider(authenticationProvider());
//                http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//                return http.build();
//    }
//
//
//}
