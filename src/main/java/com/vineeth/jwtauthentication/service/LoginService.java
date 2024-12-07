package com.vineeth.jwtauthentication.service;

import com.vineeth.jwtauthentication.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userService.getUserByEmail(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole().getRolename());
        UserDetails userDetails = buildUserForAuthentication(user,authorities);
        return userDetails;
    }

    public UserDetails buildUserForAuthentication(UserModel user, List<GrantedAuthority> authorities){
        return User.builder().username(user.getEmail()).password(user.getPassword())
                .authorities(authorities).build();
    }

    public List<GrantedAuthority> buildUserAuthority(String userRole){
        return List.of(new SimpleGrantedAuthority(userRole));
    }
}
