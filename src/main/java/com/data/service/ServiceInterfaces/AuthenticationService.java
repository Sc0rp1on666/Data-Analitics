package com.data.service.ServiceInterfaces;

import com.data.DtoObjects.AuthenticationDTO;

public interface AuthenticationService {
    String userAuthentication(AuthenticationDTO authenticationDTO);
}
