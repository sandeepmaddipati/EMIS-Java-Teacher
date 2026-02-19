package com.tns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.TeachingQualificationRequest;
import com.tns.model.TeacherProfile;
import com.tns.model.TeachingQualification;
import com.tns.repository.CountryRepository;
import com.tns.repository.MasterLookupRepository;
import com.tns.repository.TeacherProfileRepository;
import com.tns.repository.TeachingQualificationRepository;

@Service
public class TeachingQualificationService {

    @Autowired private TeachingQualificationRepository repo;
    @Autowired private TeacherProfileRepository profileRepo;
    @Autowired private MasterLookupRepository lookupRepo;
    @Autowired private CountryRepository countryRepo;

    public String saveOrUpdate(TeachingQualificationRequest request){

        TeacherProfile teacher =
                profileRepo.findByUser_UserId(request.getUserId())
                        .orElseThrow(() ->
                                new RuntimeException("Teacher profile not found"));

        TeachingQualification tq;

        if(request.getTeachingQualificationId() != null){

            tq = repo.findByTeachingQualificationIdAndTeacher_TeacherId(
                    request.getTeachingQualificationId(),
                    teacher.getTeacherId())
                    .orElseThrow(() ->
                            new RuntimeException("Teaching record not found"));

        } else {

            tq = new TeachingQualification();
            tq.setTeacher(teacher);
        }

        tq.setQualificationName(request.getQualificationName());

        tq.setCertificationType(
                lookupRepo.findByLookupTypeAndLookupValue(
                        "CERTIFICATION_TYPE",
                        request.getCertificationType())
                        .orElseThrow());

        tq.setInstitutionName(request.getInstitutionName());

        tq.setCountry(
                countryRepo.findById(request.getCountryId())
                        .orElseThrow());

        tq.setStartYear(request.getStartYear());
        tq.setEndYear(request.getEndYear());

        repo.save(tq);

        return request.getTeachingQualificationId() != null
                ? "Teaching qualification updated"
                : "Teaching qualification added";
    }
}
