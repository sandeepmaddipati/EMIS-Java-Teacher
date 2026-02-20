package com.tns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.TeachingQualificationRequest;
import com.tns.dto.TeachingQualificationResponse;
import com.tns.model.Country;
import com.tns.model.MasterLookup;
import com.tns.model.TeacherProfile;
import com.tns.model.TeachingQualification;
import com.tns.repository.CountryRepository;
import com.tns.repository.MasterLookupRepository;
import com.tns.repository.TeacherProfileRepository;
import com.tns.repository.TeachingQualificationRepository;

@Service
public class TeachingQualificationService {
    @Autowired private TeachingQualificationRepository repo;
    @Autowired private TeacherProfileRepository teacherRepo;
    @Autowired private MasterLookupRepository lookupRepo;
    @Autowired private CountryRepository countryRepo;

    public String saveOrUpdate(TeachingQualificationRequest req) {
        TeachingQualification tq = (req.getTeachingQualificationId() != null)
            ? repo.findById(req.getTeachingQualificationId()).orElse(new TeachingQualification())
            : new TeachingQualification();

        TeacherProfile teacher = teacherRepo.findById(req.getTeacherId())
            .orElseThrow(() -> new RuntimeException("Teacher not found"));

        MasterLookup certType = lookupRepo.findByLookupTypeAndLookupValue("CERTIFICATION_TYPE", req.getCertificationType())
            .orElseThrow(() -> new RuntimeException("Invalid certification type"));

        Country country = countryRepo.findByCountryName(req.getCountryName())
            .orElseThrow(() -> new RuntimeException("Invalid country"));

        tq.setTeacher(teacher);
        tq.setQualificationName(req.getQualificationName());
        tq.setCertificationType(certType);
        tq.setInstitutionName(req.getInstitutionName());
        tq.setCountry(country);
        tq.setStartYear(req.getStartYear());
        tq.setEndYear(req.getEndYear());

        repo.save(tq);

        return req.getTeachingQualificationId() != null
                ? "Teaching qualification updated successfully"
                : "Teaching qualification added successfully";

    }

    public List<TeachingQualificationResponse> getAllByTeacher(Long teacherId) {
        return repo.findByTeacher_TeacherId(teacherId).stream().map(this::map).toList();
    }

    private TeachingQualificationResponse map(TeachingQualification tq) {
        TeachingQualificationResponse r = new TeachingQualificationResponse();
        r.setTeachingQualificationId(tq.getTeachingQualificationId());
        r.setQualificationName(tq.getQualificationName());
        r.setCertificationTypeId(tq.getCertificationType()!=null?tq.getCertificationType().getLookupValue():null);
        r.setInstitutionName(tq.getInstitutionName());
        r.setCountryName(tq.getCountry()!=null?tq.getCountry().getCountryName():null);
        r.setStartYear(tq.getStartYear());
        r.setEndYear(tq.getEndYear());
        return r;
    }
}