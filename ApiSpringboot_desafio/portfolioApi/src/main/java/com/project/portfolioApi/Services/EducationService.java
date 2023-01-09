/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Education;
import com.project.portfolioApi.Repositories.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{

    @Autowired
    EducationRepository eduRepo;
    
    @Override
    public void createEducation(Education newEducation) {
        eduRepo.save(newEducation);
    }

    @Override
    public List<Education> getEducation() {
        return eduRepo.findAll();
    }

    @Override
    public Education getEducationById(Long id) {
        return eduRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }
    
}
