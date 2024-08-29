package com.ayushmaan.JobPortal.service;

import com.ayushmaan.JobPortal.model.User;
import com.ayushmaan.JobPortal.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserPrincipal implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user != null){
            return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(Arrays.toString(user.getAuthLevel().toArray(new String[0])))
                .build();
        }
        throw new UsernameNotFoundException("User not found with giver username: " + username);
    }
}
