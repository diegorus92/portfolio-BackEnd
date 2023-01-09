/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Institution;
import com.project.portfolioApi.Repositories.InstitutionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService implements IInstitutionService{

    @Autowired
    InstitutionRepository instiRepo;
    
    @Override
    public void createInstitution(Institution newInstitution) {
        instiRepo.save(newInstitution);
    }

    @Override
    public List<Institution> getInstitution() {
        return instiRepo.findAll();
    }

    @Override
    public Institution getInstitutionById(Long id) {
        return instiRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteInstitution(Long id) {
        instiRepo.deleteById(id);
    }
    
    
}
