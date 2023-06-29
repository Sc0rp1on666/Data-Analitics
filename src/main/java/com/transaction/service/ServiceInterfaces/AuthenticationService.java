package com.transaction.service.ServiceInterfaces;

import com.transaction.DtoObjects.AuthenticationDTO;

public interface AuthenticationService {
    String userAuthentication(AuthenticationDTO authenticationDTO);
}
