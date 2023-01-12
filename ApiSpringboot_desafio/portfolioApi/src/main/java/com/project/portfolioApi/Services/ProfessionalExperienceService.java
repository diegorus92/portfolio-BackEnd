/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.ProfessionalExperience;
import com.project.portfolioApi.Repositories.ProfessionalExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalExperienceService implements IProfessionalExperienceService{

    @Autowired
    ProfessionalExperienceRepository proExpRepo;
    
    @Override
    public void createProfessionalExp(ProfessionalExperience newProfessionalExp) {
        proExpRepo.save(newProfessionalExp);
    }

    @Override
    public List<ProfessionalExperience> getProfessionalExperiences() {
        return proExpRepo.findAll();
    }

    @Override
    public ProfessionalExperience getProfessionalExpById(Long id) {
        return proExpRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProfessionalExp(Long id) {
        proExpRepo.deleteById(id);
    }
    
}
