//package com.data.configuration.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class JwtTokenFilter extends OncePerRequestFilter {
//    private JwtTokenProvider jwtTokenProvider;
//
//    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String token = jwtTokenProvider.extractTokenFromRequest((HttpServletRequest) request);
//        if(StringUtils.hasText(token)&& jwtTokenProvider.validateToken(token)){
//            Authentication authentication =jwtTokenProvider.getAuthentication(token);
//            if(authentication!=null){
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        filterChain.doFilter(request,response);
//    }
//}