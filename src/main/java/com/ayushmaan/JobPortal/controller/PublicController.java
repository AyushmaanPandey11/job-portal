package com.ayushmaan.JobPortal.controller;

import com.ayushmaan.JobPortal.model.User;
import com.ayushmaan.JobPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            User CreatedUser = userService.saveNewUser(user);
            return new ResponseEntity<>(CreatedUser, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
