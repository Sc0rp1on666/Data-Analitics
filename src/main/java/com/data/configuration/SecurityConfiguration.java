//package com.data.configuration;
//
//import com.data.configuration.security.JwtTokenFilter;
//import com.data.configuration.security.JwtTokenProvider;
//import com.data.configuration.security.UserDetailService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration{
//    private final JwtTokenProvider jwtTokenProvider;
//    private final UserDetailService userDetailService;
//
//    public SecurityConfiguration(JwtTokenProvider jwtTokenProvider, UserDetailService userDetailService) {
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.userDetailService = userDetailService;
//    }
//    @Bean
//    public JwtTokenFilter jwtTokenFilter(){
//        return new JwtTokenFilter(jwtTokenProvider);
//    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return  authenticationProvider;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
//        return http.getSharedObject(AuthenticationManagerBuilder.class).authenticationProvider(authenticationProvider()).build();
//    }
//
//    protected void configuration(HttpSecurity http) throws Exception{
//        http.csrf().disable()
//                .cors().disable()
//                .authorizeRequests().antMatchers("/user**").permitAll().anyRequest().authenticated()
//                .and()
//                .authorizeRequests().antMatchers("/auth**").permitAll().anyRequest().authenticated()
//                //TODO: add form login once it will be done, for now make an authorize controller, get rid of WebSecurityAdapter
//                .and()
//                .logout().invalidateHttpSession(true)
//                .clearAuthentication(true).permitAll();
//
//    }
//}
