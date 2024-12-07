package com.vineeth.jwtauthentication.repository;

import com.vineeth.jwtauthentication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRepo extends JpaRepository<UserModel, Integer> {
    UserModel findByEmail(String email);
}
