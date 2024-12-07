package com.vineeth.jwtauthentication.security;

import com.vineeth.jwtauthentication.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtility implements Serializable {


    @Serial
    private static final long serialVersionUID = 7131602650216589996L;
    public static final String secretKey ="ItsageneralRandomKeyforthetokenforloggedinuser";
    public static final Date exp = new Date(System.currentTimeMillis()+3600000);

    @Autowired
    private UserService userService;

    public Claims getAllExtractClaims(String token){
        Claims claims = Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody();
        return claims;
    }

    public <T> T getClaimFromToken(String token, Function<Claims,T> claimResolver){
        try{
            Claims claims = getAllExtractClaims(token);
            return claimResolver.apply(claims);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Date getExpireToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public String getUserFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles",userDetails.getAuthorities());
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String doGenerateToken(Map<String, Object> claims, String subject){
        return Jwts.builder()
                .setSubject(subject)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    public boolean isTokenExipred(String token){
        return getExpireToken(token).after(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUserFromToken(token);
        return username.equals(userDetails.getUsername()) && isTokenExipred(token);
    }

}
