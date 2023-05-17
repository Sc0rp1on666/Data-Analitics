package com.data.configuration.security;

import com.data.dao.interfaces.RoleDao;
import com.data.dao.interfaces.UserDao;
import com.data.entity.Role;
import com.data.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailService  implements UserDetailsService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    public UserDetailService(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    public CustomUserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userDao.getUserByEmail(userEmail);
        if(user==null){
            throw new UsernameNotFoundException("user not found or doesn't exist");
        }
        Collection<? extends GrantedAuthority> authorities = getUserAuthorities(roleDao.getRoles(user.getUserId()));
        return new CustomUserDetails(user.getEmail(),user.getPassword(),authorities) {
        };
    }

    private Collection<? extends GrantedAuthority> getUserAuthorities(Collection<Role> role){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role roles:role){
            authorities.add(new SimpleGrantedAuthority(roles.getUserRoleName()));
        }
        return authorities;
    }
}
