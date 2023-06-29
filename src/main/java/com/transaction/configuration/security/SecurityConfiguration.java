package com.transaction.configuration.security;

//import com.data.service.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration implements WebMvcConfigurer{
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



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.cors().configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/user**").permitAll()
                .antMatchers("/transaction**").permitAll();
                //TODO: add form login once it will be done, for now make an authorize controller, get rid of WebSecurityAdapter
//                .and()
//                .authorizeRequests().anyRequest().authenticated();
//                http.authenticationProvider(authenticationProvider());
//                http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
                return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config);
        return source;
    }

}
