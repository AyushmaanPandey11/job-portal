package com.ayushmaan.JobPortal.controller;

import com.ayushmaan.JobPortal.model.User;
import com.ayushmaan.JobPortal.service.JwtService;
import com.ayushmaan.JobPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            User CreatedUser = userService.saveNewUser(user);
            return new ResponseEntity<>(CreatedUser, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/sign-user")
    public ResponseEntity<?> login(@RequestBody User user){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            String token = jwtService.generateToken(user.getUsername());
            return new ResponseEntity<>(token,HttpStatus.ACCEPTED);
        }else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
