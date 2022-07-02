package com.stackroute.capstone.services;

import com.stackroute.capstone.model.User;
import com.stackroute.capstone.repository.RegistrationRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegistrationServiceImpl implements registrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    @Override
    public User saveUser(User user) {
       return registrationRepository.save(user);
    }

    @Override
    public User fetchUserByEmailId(String email) {
        return registrationRepository.findByEmail(email);
    }

    @Override
    public User fetchUserByEmailAndPassword(String email, String password) {
        return registrationRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public boolean updateUser(User user) {
        try {
            registrationRepository.delete(user);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public String getToken(User user) {
        String token=null;
        token= Jwts.builder()
                .setSubject(user.getName())
                .claim("user",user.getName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"myPassword")
                .compact();
        return token;

    }

    @Override
    public boolean validateToken(String token) {
        Claims claims=Jwts.parser()
                .setSigningKey("myPassword")
                .parseClaimsJws(token)
                .getBody();
        if(claims !=null)
        {
            return true;
        }
        return false;

    }
}
