package com.tns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.WorkExperienceRequest;
import com.tns.model.TeacherProfile;
import com.tns.model.WorkExperience;
import com.tns.repository.CountryRepository;
import com.tns.repository.DistrictRepository;
import com.tns.repository.StateRepository;
import com.tns.repository.TeacherProfileRepository;
import com.tns.repository.WorkExperienceRepository;

@Service
public class WorkExperienceService {

    @Autowired private WorkExperienceRepository repo;
    @Autowired private TeacherProfileRepository profileRepo;
    @Autowired private CountryRepository countryRepo;
    @Autowired private StateRepository stateRepo;
    @Autowired private DistrictRepository districtRepo;

    public String saveOrUpdate(WorkExperienceRequest request){

        TeacherProfile teacher =
                profileRepo.findByUser_UserId(request.getUserId())
                        .orElseThrow(() ->
                                new RuntimeException("Teacher profile not found"));

        WorkExperience we;

        if(request.getWorkId() != null){

            we = repo.findByWorkIdAndTeacher_TeacherId(
                    request.getWorkId(),
                    teacher.getTeacherId())
                    .orElseThrow(() ->
                            new RuntimeException("Work record not found"));

        } else {

            we = new WorkExperience();
            we.setTeacher(teacher);
        }

        we.setJobTitle(request.getJobTitle());
        we.setInstitutionName(request.getInstitutionName());

        we.setCountry(countryRepo.findById(request.getCountryId()).orElseThrow());
        we.setState(stateRepo.findById(request.getStateId()).orElseThrow());
        we.setDistrict(districtRepo.findById(request.getDistrictId()).orElseThrow());

        we.setStartMonth(request.getStartMonth());
        we.setStartYear(request.getStartYear());
        we.setEndMonth(request.getEndMonth());
        we.setEndYear(request.getEndYear());

        we.setReferenceName(request.getReferenceName());
        we.setReferencePhone(request.getReferencePhone());
        we.setReferenceEmail(request.getReferenceEmail());
        we.setSupportingDocument(request.getSupportingDocument());

        repo.save(we);

        return request.getWorkId() != null
                ? "Work experience updated"
                : "Work experience added";
    }
}
