/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.SkillType;
import com.project.portfolioApi.Repositories.SkillTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillTypeService implements ISkillTypeService{

    @Autowired
    SkillTypeRepository skillTypeRepo;
    
    @Override
    public void createSkillType(SkillType newSkillType) {
        skillTypeRepo.save(newSkillType);
    }

    @Override
    public List<SkillType> getSkillTypes() {
        return skillTypeRepo.findAll();
    }

    @Override
    public SkillType getSkillTypeById(Long id) {
        return skillTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSkillType(Long id) {
        skillTypeRepo.deleteById(id);
    }
    
}
