package com.example.evelin.controller;

import com.example.evelin.dto.ProfileDto;
import com.example.evelin.model.Profile;
import com.example.evelin.model.Result;
import com.example.evelin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public HttpEntity<?> getProfiles(){
        List<Profile> profiles = profileService.getProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getProfileById(@PathVariable Integer id){
        Profile profile = profileService.getProfileById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addProfile(@RequestBody ProfileDto profileDto){
        Result result = profileService.addProfile(profileDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateProfile(@PathVariable Integer id, @RequestBody ProfileDto profileDto){
        Result result = profileService.updateProfile(id, profileDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteProfile(@PathVariable Integer id){
        Result result = profileService.deleteProfile(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
