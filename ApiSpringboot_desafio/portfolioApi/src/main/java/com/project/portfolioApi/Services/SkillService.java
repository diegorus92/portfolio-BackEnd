/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Skill;
import com.project.portfolioApi.Repositories.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{

    @Autowired
    SkillRepository skillRepo;
    
    @Override
    public void createSkill(Skill newSkill) {
        skillRepo.save(newSkill);
    }

    @Override
    public List<Skill> getSkills() {
        return skillRepo.findAll();
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }
    
}
