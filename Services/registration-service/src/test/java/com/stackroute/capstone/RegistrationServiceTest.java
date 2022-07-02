package com.stackroute.capstone;

import com.stackroute.capstone.model.User;
import com.stackroute.capstone.services.registrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RegistrationServiceTest {

    @Autowired
    registrationService registerService;

    @Test
    public void testSaveUser(){
        User u=new User(100,"test1","testmail1@gmail.com","94647529300","password");
        User u1=registerService.saveUser(u);
        assertTrue(u1.getName().equals(u.getName()));
        assertTrue(u1.getEmail().equals(u.getEmail()));
        assertTrue(u1.getPassword().equals(u.getPassword()));
    }
    @Test
    public void testFetchUserByEmailId(){
        User u=new User(101,"test2","testmail2@gmail.com","94647529300","password");
        u=registerService.saveUser(u);
        assertTrue(registerService.fetchUserByEmailId("testmail2@gmail.com").equals(u));
    }
    @Test
    public void testFetchUserByEmailAndPassword(){
        User u=new User(102,"test3","testmail3@gmail.com","94647529300","password");
        u=registerService.saveUser(u);
        assertTrue(registerService.fetchUserByEmailAndPassword("testmail3@gmail.com","password").equals(u));
    }
    @Test
    public void testUpdateUser(){
        User u=new User(103,"test4","testmail4@gmail.com","94647529300","password");
        u=registerService.saveUser(u);
        assertTrue(registerService.updateUser(u));
        assertFalse(registerService.updateUser(null));
    }
    @Test
    public void testGetToken(){
        User u=new User(103,"test4","testmail4@gmail.com","94647529300","password");
        String token=registerService.getToken(u);
        assertTrue(registerService.validateToken(token));
    }
}
