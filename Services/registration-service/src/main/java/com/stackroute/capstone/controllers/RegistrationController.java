package com.stackroute.capstone.controllers;

import com.stackroute.capstone.ExceptionHandler.UserException;
import com.stackroute.capstone.model.User;
import com.stackroute.capstone.services.RegistrationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authenticate/v1")
public class RegistrationController {
    @Autowired
    private RegistrationServiceImpl service;
    public RegistrationController(RegistrationServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/registeruser")
    //registration request
    public User registerUser(@RequestBody User user) throws UserException
    {   String tempEmailId=user.getEmail();
        if(tempEmailId!=null&&!"".equals(tempEmailId))
            {
                User userobj =service.fetchUserByEmailId(tempEmailId);
                if(userobj!=null){
                    throw new UserException("User with" + tempEmailId+" already exists");
                }
            }
        return service.saveUser(user);
    }
    //login request
    @PostMapping("/loginuser")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody User user) throws UserException
    {   Map<String, String> response=new HashMap<>();
        String tempEmailId= user.getEmail();
        String tempPassword= user.getPassword();
        User userObj=null;
        if(tempEmailId !=null && tempPassword != null)
            {
                userObj=service.fetchUserByEmailAndPassword(tempEmailId,tempPassword);
            }
        if(userObj==null)
            {
                throw new UserException("User does not exists");
            }
        //send token when login successfull
        String token=service.getToken(user);
        response.put("token",token);
        response.put("id",userObj.getId().toString());
        response.put("status",HttpStatus.OK.toString());

        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
    //change password request
    @PostMapping("/password")
    public User changePassword(@RequestBody User user) throws Exception
    {
        String tempEmailId= user.getEmail();
        String tempPassword= user.getPassword();
        User userObj=null;
        if(tempEmailId !=null && tempPassword != null)
            {
                userObj=service.fetchUserByEmailId(tempEmailId);
                userObj.setPassword(tempPassword);
                service.saveUser(userObj);
            }
        if(userObj==null)
        {
            throw new Exception("User does not exists");
        }

        return userObj;
    }
    @PostMapping(value = "/authenticate")
    public ResponseEntity<Map<String, String>> authenticateUser(
            @RequestHeader("Authorization") String token) {

        Map<String, String> response = new HashMap<>();
        if (!service.validateToken(token.substring(7))) {
            response.put("message", "Invalid token");
            response.put("status", HttpStatus.UNAUTHORIZED.toString());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        response.put("message", "Valid token");
        response.put("status", HttpStatus.OK.toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
