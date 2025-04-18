package com.example.evelin.service;

import com.example.evelin.dto.ProfileDto;
import com.example.evelin.model.Attach;
import com.example.evelin.model.Profile;
import com.example.evelin.model.Result;
import com.example.evelin.repository.AttachRepo;
import com.example.evelin.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    AttachRepo  attachRepo;

    public List<Profile> getProfiles(){
        return profileRepo.findAll();
    }

    public Profile getProfileById(Integer id){
        return profileRepo.findById(id).get();
    }

    public Result addProfile(ProfileDto profileDto){
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setSurname(profileDto.getSurname());
        profile.setEmail(profileDto.getEmail());
        profile.setPassword(profileDto.getPassword());

        Optional<Attach> optionalAttach = attachRepo.findById(profileDto.getPhoto_id());
        Attach attach = optionalAttach.get();
        profile.setPhoto_id((List<Attach>) attach);

        profileRepo.save(profile);
        return new Result(true,"Profile added successfully");
    }

    public Result updateProfile(Integer id, ProfileDto profileDto){
        Optional<Profile> optionalProfile = profileRepo.findById(id);
        if(optionalProfile.isPresent()){
            Profile profile = optionalProfile.get();
            profile.setName(profileDto.getName());
            profile.setSurname(profileDto.getSurname());
            profile.setEmail(profileDto.getEmail());
            profile.setPassword(profileDto.getPassword());

            Optional<Attach> optionalAttach = attachRepo.findById(profileDto.getPhoto_id());
            Attach attach = optionalAttach.get();
            profile.setPhoto_id((List<Attach>) attach);

            profileRepo.save(profile);
            return new Result(true,"Profile updated successfully");
        }
        return new Result(false,"Profile not found");
    }

    public Result deleteProfile(Integer id){
        Optional<Profile> optionalProfile = profileRepo.findById(id);
        if(optionalProfile.isPresent()){
            profileRepo.deleteById(id);
            return new Result(true,"Profile deleted successfully");
        }
        return new Result(false,"Profile not found");
    }

}
