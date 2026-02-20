package com.tns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.AcademicQualificationRequest;
import com.tns.dto.AcademicQualificationResponse;
import com.tns.model.AcademicQualification;
import com.tns.model.Country;
import com.tns.model.MasterLookup;
import com.tns.model.TeacherProfile;
import com.tns.repository.AcademicQualificationRepository;
import com.tns.repository.CountryRepository;
import com.tns.repository.MasterLookupRepository;
import com.tns.repository.TeacherProfileRepository;

@Service
public class AcademicQualificationService {
    @Autowired private AcademicQualificationRepository repo;
    @Autowired private TeacherProfileRepository teacherRepo;
    @Autowired private MasterLookupRepository lookupRepo;
    @Autowired private CountryRepository countryRepo;

    public String saveOrUpdate(AcademicQualificationRequest req) {
        AcademicQualification aq = (req.getAcademicQualificationId() != null)
            ? repo.findById(req.getAcademicQualificationId()).orElse(new AcademicQualification())
            : new AcademicQualification();

        TeacherProfile teacher = teacherRepo.findById(req.getTeacherId())
        	    .orElseThrow(() -> new RuntimeException("Teacher not found"));

        	MasterLookup level = lookupRepo.findByLookupTypeAndLookupValue("QUALIFICATION_LEVEL", req.getQualificationLevel())
        	    .orElseThrow(() -> new RuntimeException("Invalid qualification level"));

        	Country country = countryRepo.findByCountryName(req.getCountryName())
        	    .orElseThrow(() -> new RuntimeException("Invalid country"));

        	aq.setTeacher(teacher);          // ✅ TeacherProfile
        	aq.setQualificationLevel(level); // ✅ MasterLookup
        	aq.setInstitutionName(req.getInstitutionName());
        	aq.setFieldOfStudy(req.getFieldOfStudy());
        	aq.setCountry(country);          // ✅ Country
        	aq.setStartYear(req.getStartYear());
        	aq.setEndYear(req.getEndYear());


        	 repo.save(aq);

             return req.getAcademicQualificationId() != null
                     ? "Academic qualification updated successfully"
                     : "Academic qualification added successfully";

    }
    public List<AcademicQualificationResponse> getAllByTeacher(Long teacherId) {
        return repo.findByTeacher_TeacherId(teacherId)
                   .stream()
                   .map(this::map)
                   .toList();
    }

    private AcademicQualificationResponse map(AcademicQualification aq) {
        AcademicQualificationResponse r = new AcademicQualificationResponse();
        r.setAcademicQualificationId(aq.getAcademicQualificationId());
        r.setQualificationLevel(aq.getQualificationLevel()!=null?aq.getQualificationLevel().getLookupValue():null);
        r.setInstitutionName(aq.getInstitutionName());
        r.setFieldOfStudy(aq.getFieldOfStudy());
        r.setCountry(aq.getCountry()!=null?aq.getCountry().getCountryName():null);
        r.setStartYear(aq.getStartYear());
        r.setEndYear(aq.getEndYear());
        return r;
    }

	
}