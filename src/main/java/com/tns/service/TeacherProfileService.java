package com.tns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.TeacherProfileRequest;
import com.tns.model.TeacherProfile;
import com.tns.model.User;
import com.tns.repository.MasterLookupRepository;
import com.tns.repository.TeacherProfileRepository;
import com.tns.repository.UserRepository;

@Service
public class TeacherProfileService {

    @Autowired private TeacherProfileRepository repo;
    @Autowired private UserRepository userRepo;
    @Autowired private MasterLookupRepository lookupRepo;

    public String saveOrUpdate(TeacherProfileRequest request){

        User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean exists = repo.existsByUser_UserId(request.getUserId());

        TeacherProfile profile =
                repo.findByUser_UserId(request.getUserId())
                        .orElse(new TeacherProfile());

        profile.setUser(user);
        profile.setFullName(request.getFullName());
        profile.setPhoneNumber(request.getPhoneNumber());
        profile.setDateOfBirth(request.getDateOfBirth());

        profile.setGender(
                lookupRepo.findByLookupTypeAndLookupValue(
                        "GENDER", request.getGender()).orElseThrow());

        profile.setMaritalStatus(
                lookupRepo.findByLookupTypeAndLookupValue(
                        "MARITAL_STATUS", request.getMaritalStatus()).orElseThrow());

        profile.setNationality(
                lookupRepo.findByLookupTypeAndLookupValue(
                        "NATIONALITY", request.getNationality()).orElseThrow());

        profile.setNationalIdNumber(request.getNationalIdNumber());
        profile.setAddress(request.getAddress());
        profile.setProfilePhotoPath(request.getProfilePhotoPath());

        repo.save(profile);

        return exists ?
                "Profile updated successfully" :
                "Profile created successfully";
    }
}

