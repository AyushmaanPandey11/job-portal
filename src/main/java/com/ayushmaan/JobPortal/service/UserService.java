package com.ayushmaan.JobPortal.service;

import com.ayushmaan.JobPortal.model.User;
import com.ayushmaan.JobPortal.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveNewUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(String.valueOf(List.of("USER")));
        userRepo.save(user);
        return user;
    }

    public User findByUserName(String userName) {
        return userRepo.findByUsername(userName);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User saveAdmin(User user) {
        User existingUser = userRepo.findByUsername(user.getUsername());
        if(existingUser!=null){
            existingUser.setPassword(encoder.encode(user.getPassword()));
            existingUser.setRole(String.valueOf(List.of("USER","ADMIN")));
            userRepo.save(existingUser);
            return existingUser;
        }else {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRole(String.valueOf(List.of("USER","ADMIN")));
            userRepo.save(user);
            return user;
        }
    }
}
