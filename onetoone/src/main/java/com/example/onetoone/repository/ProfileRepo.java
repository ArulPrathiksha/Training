package com.example.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetoone.entity.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {

}
