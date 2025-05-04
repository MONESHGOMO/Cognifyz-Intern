package com.Convo.Convo.controllers;

import com.Convo.Convo.models.ApplicationUsers;
import com.Convo.Convo.services.ApplicationUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/authentication")
public class RegistrationController {

    private final ApplicationUserService applicationUserService;

    private final PasswordEncoder passwordEncoder;

    public RegistrationController(ApplicationUserService applicationUserService, PasswordEncoder passwordEncoder) {
        this.applicationUserService = applicationUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody ApplicationUsers registerNewUser) {
        try {
            registerNewUser.setPassword(passwordEncoder.encode(registerNewUser.getPassword()));
            applicationUserService.registerUser(registerNewUser);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        }
        catch (IllegalAccessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}