package com.tns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.TeacherProfileRequest;
import com.tns.dto.TeacherProfileResponse;
import com.tns.model.TeacherProfile;
import com.tns.repository.MasterLookupRepository;
import com.tns.repository.TeacherProfileRepository;
import com.tns.repository.UserRepository;

@Service
public class TeacherProfileService {
    @Autowired private TeacherProfileRepository repo;
    @Autowired private UserRepository userRepo;
    @Autowired private MasterLookupRepository lookupRepo;

    public String saveOrUpdate(TeacherProfileRequest req) {
        // If profile exists for this user, update it; else create new
        TeacherProfile profile = repo.findByUser_UserId(req.getUserId())
            .orElse(new TeacherProfile());

        profile.setUser(userRepo.findById(req.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found")));
        profile.setFullName(req.getFullName());
        profile.setPhoneNumber(req.getPhoneNumber());
        profile.setDateOfBirth(req.getDateOfBirth());

        if (req.getGender() != null) {
            profile.setGender(lookupRepo.findByLookupTypeAndLookupValue("GENDER", req.getGender())
                .orElseThrow(() -> new RuntimeException("Invalid gender")));
        }
        if (req.getMaritalStatus() != null) {
            profile.setMaritalStatus(lookupRepo.findByLookupTypeAndLookupValue("MARITAL_STATUS", req.getMaritalStatus())
                .orElseThrow(() -> new RuntimeException("Invalid marital status")));
        }
        if (req.getNationality() != null) {
            profile.setNationality(lookupRepo.findByLookupTypeAndLookupValue("NATIONALITY", req.getNationality())
                .orElseThrow(() -> new RuntimeException("Invalid nationality")));
        }

        profile.setNationalIdNumber(req.getNationalIdNumber());
        profile.setAddress(req.getAddress());
        profile.setProfilePhotoPath(req.getProfilePhotoPath());

        repo.save(profile);

        return profile.getTeacherId() != null
            ? "Teacher profile updated successfully"
            : "Teacher profile saved successfully";

    }

    public TeacherProfileResponse getByUser(Long userId) {
        return repo.findByUser_UserId(userId).map(this::map)
            .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    private TeacherProfileResponse map(TeacherProfile p) {
        TeacherProfileResponse r = new TeacherProfileResponse();
        r.setTeacherId(p.getTeacherId());
        r.setFullName(p.getFullName());
        r.setPhoneNumber(p.getPhoneNumber());
        r.setGender(p.getGender()!=null?p.getGender().getLookupValue():null);
        r.setMaritalStatus(p.getMaritalStatus()!=null?p.getMaritalStatus().getLookupValue():null);
        r.setNationality(p.getNationality()!=null?p.getNationality().getLookupValue():null);
        r.setNationalIdNumber(p.getNationalIdNumber());
        r.setAddress(p.getAddress());
        r.setProfilePhotoPath(p.getProfilePhotoPath());
        return r;
    }
}