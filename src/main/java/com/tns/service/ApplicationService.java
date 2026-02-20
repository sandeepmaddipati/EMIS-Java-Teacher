package com.tns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.ApplicationRequest;
import com.tns.dto.ApplicationResponse;
import com.tns.model.Application;
import com.tns.model.MasterLookup;
import com.tns.model.TeacherProfile;
import com.tns.repository.ApplicationRepository;
import com.tns.repository.MasterLookupRepository;
import com.tns.repository.TeacherProfileRepository;

@Service
public class ApplicationService {
    @Autowired private ApplicationRepository repo;
    @Autowired private TeacherProfileRepository teacherRepo;
    @Autowired private MasterLookupRepository lookupRepo;

    public String submit(ApplicationRequest req) {
        Application app = new Application();

        TeacherProfile teacher = teacherRepo.findById(req.getTeacherId())
            .orElseThrow(() -> new RuntimeException("Teacher not found"));

        MasterLookup status = lookupRepo.findByLookupTypeAndLookupValue("APPLICATION_STATUS", "SUBMITTED")
            .orElseThrow(() -> new RuntimeException("Status not found"));

        app.setTeacher(teacher);
        app.setStatus(status);

        repo.save(app);
        return "Application Submitted successfully";
    }

    public List<ApplicationResponse> getAllByTeacher(Long teacherId) {
        return repo.findByTeacher_TeacherId(teacherId).stream().map(this::map).toList();
    }

    private ApplicationResponse map(Application app) {
        ApplicationResponse r = new ApplicationResponse();
        r.setApplicationId(app.getApplicationId());
        r.setTeacherName(app.getTeacher().getFullName());
        r.setStatus(app.getStatus()!=null?app.getStatus().getLookupValue():null);
        r.setSubmittedAt(app.getSubmittedAt());
        return r;
    }
}