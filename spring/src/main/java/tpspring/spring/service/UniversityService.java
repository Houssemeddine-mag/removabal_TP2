package tpspring.spring.service;

import tpspring.spring.model.University;
import tpspring.spring.repository.UniversityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;


    public University saveUniversity(University university) {
    return universityRepository.save(university);
    }

    public List<University> getAllUniversities() {
    return universityRepository.findAll();
    }
}