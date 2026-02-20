package com.tns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.dto.WorkExperienceRequest;
import com.tns.dto.WorkExperienceResponse;
import com.tns.model.Country;
import com.tns.model.District;
import com.tns.model.State;
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
    @Autowired private TeacherProfileRepository teacherRepo;
    @Autowired private CountryRepository countryRepo;
    @Autowired private StateRepository stateRepo;
    @Autowired private DistrictRepository districtRepo;

    public String saveOrUpdate(WorkExperienceRequest req) {
        WorkExperience w = (req.getWorkId() != null)
            ? repo.findById(req.getWorkId()).orElse(new WorkExperience())
            : new WorkExperience();

        TeacherProfile teacher = teacherRepo.findById(req.getTeacherId())
            .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Country country = countryRepo.findByCountryName(req.getCountryName())
            .orElseThrow(() -> new RuntimeException("Invalid country"));
        State state = stateRepo.findByStateName(req.getStateName())
            .orElseThrow(() -> new RuntimeException("Invalid state"));
        
        District district = districtRepo.findByDistrictName(req.getDistrictName())
            .orElseThrow(() -> new RuntimeException("Invalid district"));

        w.setTeacher(teacher);
        w.setJobTitle(req.getJobTitle());
        w.setInstitutionName(req.getInstitutionName());
        w.setCountry(country);
        w.setState(state);
        w.setDistrict(district);
        w.setStartMonth(req.getStartMonth());
        w.setStartYear(req.getStartYear());
        w.setEndMonth(req.getEndMonth());
        w.setEndYear(req.getEndYear());
        w.setReferenceName(req.getReferenceName());
        w.setReferencePhone(req.getReferencePhone());
        w.setReferenceEmail(req.getReferenceEmail());
        w.setSupportingDocument(req.getSupportingDocument());

        
   repo.save(w);
        		
        return req.getWorkId() != null
                ? "Work Experience updated successfully"
                : "Work Experience added successfully";
    }

    public List<WorkExperienceResponse> getAllByTeacher(Long teacherId) {
        return repo.findByTeacher_TeacherId(teacherId).stream().map(this::map).toList();
    }

    private WorkExperienceResponse map(WorkExperience w) {
        WorkExperienceResponse r = new WorkExperienceResponse();
        r.setWorkId(w.getWorkId());
        r.setJobTitle(w.getJobTitle());
        r.setInstitutionName(w.getInstitutionName());
        r.setCountryName(w.getCountry()!=null?w.getCountry().getCountryName():null);
        r.setStateName(w.getState()!=null?w.getState().getStateName():null);
        r.setDistrictName(w.getDistrict()!=null?w.getDistrict().getDistrictName():null);
        r.setStartMonth(w.getStartMonth());
        r.setStartYear(w.getStartYear());
        r.setEndMonth(w.getEndMonth());
        r.setEndYear(w.getEndYear());
        r.setReferenceName(w.getReferenceName());
        r.setReferencePhone(w.getReferencePhone());
        r.setReferenceEmail(w.getReferenceEmail());
        r.setSupportingDocument(w.getSupportingDocument());
        return r;
    }
}