package com.tns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.AcademicQualificationRequest;
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
    @Autowired private TeacherProfileRepository profileRepo;
    @Autowired private MasterLookupRepository lookupRepo;
    @Autowired private CountryRepository countryRepo;

    public String saveOrUpdate(AcademicQualificationRequest request){

        TeacherProfile teacher =
                profileRepo.findByUser_UserId(request.getUserId())
                        .orElseThrow(() ->
                                new RuntimeException("Teacher profile not found"));

        AcademicQualification aq;

        if(request.getAcademicQualificationId() != null){
            aq = repo.findByAcademicQualificationIdAndTeacher_TeacherId(
                    request.getAcademicQualificationId(),
                    teacher.getTeacherId())
                    .orElseThrow(() ->
                            new RuntimeException("Academic record not found"));
        } else {
            aq = new AcademicQualification();
            aq.setTeacher(teacher);
        }

        MasterLookup level =
                lookupRepo.findByLookupTypeAndLookupValue(
                        "QUALIFICATION_LEVEL",
                        request.getQualificationLevel())
                        .orElseThrow(() ->
                                new RuntimeException("Invalid qualification level"));

        Country country =
                countryRepo.findById(request.getCountryId())
                        .orElseThrow(() ->
                                new RuntimeException("Invalid country"));

        aq.setQualificationLevel(level);
        aq.setInstitutionName(request.getInstitutionName());
        aq.setFieldOfStudy(request.getFieldOfStudy());
        aq.setCountry(country);
        aq.setStartYear(request.getStartYear());
        aq.setEndYear(request.getEndYear());

        repo.save(aq);

        return request.getAcademicQualificationId() != null
                ? "Academic qualification updated"
                : "Academic qualification added";
    }

    public List<AcademicQualification> getAllByUserId(Long userId){

        TeacherProfile teacher =
                profileRepo.findByUser_UserId(userId)
                        .orElseThrow();

        return repo.findByTeacher_TeacherId(teacher.getTeacherId());
    }
}
