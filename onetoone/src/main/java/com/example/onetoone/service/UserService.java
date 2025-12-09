package com.example.onetoone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.onetoone.entity.User;
import com.example.onetoone.repository.UserRepo;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        User existing = userRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setUserName(user.getUserName());
            // existing.setProfile(user.getProfile()); this creates a new profile with
            // different id

            if (existing.getProfile() != null && user.getProfile() != null) {
                existing.getProfile().setFullname(user.getProfile().getFullname());
                existing.getProfile().setPhone(user.getProfile().getPhone());
            }
        }
        return userRepo.save(existing);
    }

    public User deleteUser(Long id) {
        User existing = userRepo.findById(id).orElse(null);
        if (existing != null) {
            userRepo.delete(existing);
        }
        return existing;
    }
}
