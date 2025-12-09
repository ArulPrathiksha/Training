package com.example.onetoone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.onetoone.entity.Profile;
import com.example.onetoone.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable Long id) {
        return profileService.getProfileById(id);
    }

    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return profileService.updateProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public Profile deleteProfile(@PathVariable Long id) {
        return profileService.deleteProfile(id);
    }
}
