package com.ayushmaan.JobPortal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class healthCheck {
    @GetMapping("/health-check")
    public ResponseEntity<?> healthCheckup(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
