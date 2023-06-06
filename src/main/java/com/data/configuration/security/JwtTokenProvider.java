package com.data.configuration.security;

import io.jsonwebtoken.*;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class JwtTokenProvider {
    private String secret;
    private long tokenLife;

    public JwtTokenProvider(Environment environment) {
        this.secret = environment.getProperty("jwt.base.security");
        this.tokenLife = 7200000;
    }
    @PostConstruct
    protected void init(){
        secret= Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(Authentication authentication){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        claims.put("roles",userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        Date now = new Date();
        Date valid = new Date(now.getTime()+tokenLife);
        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(valid).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public String getUsername(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody().getSubject();
    }
    public String extractTokenFromRequest(HttpServletRequest request){
        String bearer = request.getHeader("Authorization");
        if(StringUtils.hasText(bearer)&&bearer.startsWith("Bearer ")){
            return bearer.substring(7);
        }return null;
    }

    public boolean validateToken(String token){
        try{
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date());
        }catch (JwtException | IllegalArgumentException ex){
            ex.printStackTrace();
        }return false;
    }

    public Authentication getAuthentication(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(token).parseClaimsJws(token);
        List<? extends GrantedAuthority> authorities = claimsJws.getBody().get("roles", ArrayList.class);
        return new UsernamePasswordAuthenticationToken(claimsJws.getBody().getSubject(),"",null);
    }
}
