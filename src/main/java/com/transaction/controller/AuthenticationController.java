//package com.data.controller;
//
//import com.data.DtoObjects.AuthenticationDTO;
//import com.data.DtoObjects.JwtAuthenticationResponseDto;
//import com.data.service.ServiceInterfaces.AuthenticationService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//@RequestMapping("/auth")
//@RestController
//public class AuthenticationController {
//    private final AuthenticationService authenticationService;
//
//    public AuthenticationController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//    @PostMapping("/login")
//    public ResponseEntity<JwtAuthenticationResponseDto> authentication(@RequestBody AuthenticationDTO authenticationDTO){
//        String token = authenticationService.userAuthentication(authenticationDTO);
//        return ResponseEntity.ok(new JwtAuthenticationResponseDto(token));
//    }
//}
