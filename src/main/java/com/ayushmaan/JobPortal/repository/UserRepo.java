package com.ayushmaan.JobPortal.repository;

import com.ayushmaan.JobPortal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    public User findByUsername(String username);

    void deleteByUserName(String userName);
}
