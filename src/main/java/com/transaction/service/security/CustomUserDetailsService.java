//package com.data.service.security;
//
//import com.data.configuration.security.CustomUserDetails;
//import com.data.dao.interfaces.RoleDao;
//import com.data.dao.interfaces.UserDao;
//import com.data.entity.Role;
//import com.data.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    private final UserDao userDao;
//    private final RoleDao roleDao;
//
//    public CustomUserDetailsService(UserDao userDao, RoleDao roleDao) {
//        this.userDao = userDao;
//        this.roleDao = roleDao;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userDao.getUserByEmail(email);
//        if(user==null){
//            throw new UsernameNotFoundException("user not found or doesn't exist");
//        }
//        Collection<? extends GrantedAuthority> authority = getUserAuthorities(roleDao.getRoles(user.getUserId()));
//        return new CustomUserDetails(user.getEmail(),user.getPassword(),authority);
//    }
//
//    private Collection<? extends  GrantedAuthority> getUserAuthorities(
//            Collection<Role> roles){
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for(Role role: roles){
//            authorities.add(new SimpleGrantedAuthority(role.getUserRoleName()));
//        }return authorities;
//    }
//}
