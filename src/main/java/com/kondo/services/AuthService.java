package com.kondo.services;

import com.kondo.entities.User;
import com.kondo.repositories.UserRepository;
import com.kondo.services.exceptions.ForbiddenException;
import com.kondo.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
/*
    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            Long userId = SecurityContextHolder.getContext().getAuthentication().getName();
            return repository.findByEmail(userName);

        } catch (Exception e) {
            throw new UnauthorizedException("Invalid User.");
        }
    }

    public void validateSelfOrAdmin(Long userId) {
        User user = authenticated();
        if (!user.getId().equals(userId) && (!user.hasRole("ROLE_ADMIN"))) {
            throw new ForbiddenException("Access denied!");
        }
    }*/
}
