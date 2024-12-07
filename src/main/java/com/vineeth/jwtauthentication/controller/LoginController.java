package com.vineeth.jwtauthentication.controller;

import com.vineeth.jwtauthentication.dto.LoginDTO;
import com.vineeth.jwtauthentication.model.UserModel;
import com.vineeth.jwtauthentication.security.JwtUtility;
import com.vineeth.jwtauthentication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtility jwtUtility;

    @PostMapping("/login")
    public Object login(@RequestBody LoginDTO loginDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),loginDTO.getPassword()));
        UserDetails userDetails = loginService.loadUserByUsername(loginDTO.getEmail());
        String token = jwtUtility.generateToken(userDetails);
        Map<String, Object> object = new HashMap<String, Object>();
        object.put("jwt",token);
        object.put("status", 200);
        ResponseEntity<Object> response = new ResponseEntity<>(object, HttpStatus.OK);
        return response;
    }

}
