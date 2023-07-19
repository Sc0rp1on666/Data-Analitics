package com.transaction.configuration.security;//package com.data.configuration.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class CustomUserDetails implements UserDetails {
//    private int id;
//    private String email;
//    private String password;
//    private boolean accountNotLocked;
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public CustomUserDetails(String email, String password, Collection<? extends  GrantedAuthority> authorities) {
//        this.email = email;
//        this.password = password;
//        this.authorities=authorities;
//    }
//
//    public CustomUserDetails(int id, String email, String password, boolean accountNotLocked, Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.accountNotLocked = accountNotLocked;
//        this.authorities = authorities;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAccountNotLocked(Boolean accountNotLocked){
//        this.accountNotLocked=accountNotLocked;
//    }
//
//    public boolean getAccountNotLocked(){
//        return this.accountNotLocked;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
