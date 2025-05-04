package com.Convo.Convo.services;

import com.Convo.Convo.models.ApplicationUsers;
import com.Convo.Convo.repositorys.ApplicationUsersRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {

    private final ApplicationUsersRepository applicationUsersRepository;

    public ApplicationUserService(ApplicationUsersRepository applicationUsersRepository) {
        this.applicationUsersRepository = applicationUsersRepository;
    }

    public ApplicationUsers registerUser(ApplicationUsers registerNewUser) throws IllegalAccessException {
        if (applicationUsersRepository.findByusername(registerNewUser.getUsername()).isPresent()) {
            throw new IllegalAccessException("User already exists.");
        }
        if(registerNewUser.getRole() == null){

            registerNewUser.setRole("USER");
        }
        return applicationUsersRepository.save(registerNewUser);
    }
}