package com.data.configuration.security;

import com.data.dao.interfaces.UserDao;
import com.data.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService  implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userDao.getUserByEmail(userEmail);
        if(user==null){
            throw new UsernameNotFoundException("user not found or doesn't exist");
        }
        return new CustomUserDetails(user.getEmail(),user.getPassword()) {
        };
    }
}
