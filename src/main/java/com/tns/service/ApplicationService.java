package com.tns.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.model.Application;
import com.tns.model.TeacherProfile;
import com.tns.repository.AcademicQualificationRepository;
import com.tns.repository.ApplicationRepository;
import com.tns.repository.DocumentRepository;
import com.tns.repository.MasterLookupRepository;
import com.tns.repository.TeacherProfileRepository;
import com.tns.repository.TeachingQualificationRepository;
import com.tns.repository.WorkExperienceRepository;

@Service
public class ApplicationService {

    @Autowired private ApplicationRepository repo;
    @Autowired private TeacherProfileRepository profileRepo;
    @Autowired private MasterLookupRepository lookupRepo;
    @Autowired private AcademicQualificationRepository academicRepo;
    @Autowired private TeachingQualificationRepository teachingRepo;
    @Autowired private WorkExperienceRepository workRepo;
    @Autowired private DocumentRepository documentRepo;

    public String submitApplication(Long userId){

        TeacherProfile teacher =
                profileRepo.findByUser_UserId(userId)
                        .orElseThrow(() ->
                                new RuntimeException("Profile not found"));

        // Basic validation before submit
        if(academicRepo.findByTeacher_TeacherId(
                teacher.getTeacherId()).isEmpty())
            throw new RuntimeException("Add academic qualification");

        if(teachingRepo.findAll().isEmpty())
            throw new RuntimeException("Add teaching qualification");

        if(workRepo.findAll().isEmpty())
            throw new RuntimeException("Add work experience");

        if(documentRepo.findByTeacher_TeacherId(
                teacher.getTeacherId()).isEmpty())
            throw new RuntimeException("Upload documents");

        Application app =
                repo.findByTeacher_TeacherId(
                        teacher.getTeacherId())
                        .orElse(new Application());

        app.setTeacher(teacher);

        app.setStatus(
                lookupRepo.findByLookupTypeAndLookupValue(
                        "APPLICATION_STATUS",
                        "SUBMITTED")
                        .orElseThrow());

        app.setSubmittedAt(LocalDateTime.now());

        repo.save(app);

        return "Application submitted successfully";
    }
}
