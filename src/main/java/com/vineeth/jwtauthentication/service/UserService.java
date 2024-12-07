package com.vineeth.jwtauthentication.service;

import com.vineeth.jwtauthentication.model.UserModel;
import com.vineeth.jwtauthentication.repository.RoleRepository;
import com.vineeth.jwtauthentication.repository.UserModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserModelRepo userModelRepo;

    @Autowired
    private RoleRepository roleRepository;

    public UserModel getUserByEmail(String email){
        return userModelRepo.findByEmail(email);
    }
}
