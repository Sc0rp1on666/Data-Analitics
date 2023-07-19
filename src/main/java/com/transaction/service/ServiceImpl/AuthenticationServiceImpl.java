package com.transaction.service.ServiceImpl;//package com.data.service.ServiceImpl;
//
//import com.data.DtoObjects.AuthenticationDTO;
//import com.data.configuration.security.JwtTokenProvider;
//import com.data.service.ServiceInterfaces.AuthenticationService;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthenticationServiceImpl implements AuthenticationService {
//    public AuthenticationManager authenticationManager;
//    private JwtTokenProvider jwtTokenProvider;
//
//    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Override
//    public String userAuthentication(AuthenticationDTO authenticationDTO) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                authenticationDTO.getEmail(), authenticationDTO.getPassword()));
//        return jwtTokenProvider.createToken(authentication);
//    }
//}
