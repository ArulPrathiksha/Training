package com.example.onetoone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.onetoone.entity.Profile;
import com.example.onetoone.repository.ProfileRepo;

@Service
public class ProfileService {

    private final ProfileRepo profileRepo;

    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public Profile createProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    public Profile getProfileById(Long id) {
        return profileRepo.findById(id).orElse(null);
    }

    public Profile updateProfile(Long id, Profile newProfile) {
        Profile existing = profileRepo.findById(id).orElse(null);

        if (existing != null) {
            existing.setFullname(newProfile.getFullname());
            existing.setPhone(newProfile.getPhone());
        }

        return profileRepo.save(existing);
    }

    public Profile deleteProfile(Long id) {
        Profile existing = profileRepo.findById(id).orElse(null);

        if (existing != null) {
            profileRepo.delete(existing);
        }

        return existing;
    }
}
