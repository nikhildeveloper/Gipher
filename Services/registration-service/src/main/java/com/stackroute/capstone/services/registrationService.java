package com.stackroute.capstone.services;

import com.stackroute.capstone.model.User;

public interface registrationService {
    public User saveUser(User user);


    User fetchUserByEmailId(String email);

    User fetchUserByEmailAndPassword(String email, String password);
    public boolean updateUser(User user);
    String getToken(User user);
    boolean validateToken(String token);
}
