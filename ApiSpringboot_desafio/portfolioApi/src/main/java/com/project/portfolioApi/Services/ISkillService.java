/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Skill;
import java.util.List;

/**
 *
 * @author CD
 */
public interface ISkillService {
    
    public void createSkill(Skill newSkill);
    public List<Skill> getSkills();
    public Skill getSkillById(Long id);
    public void deleteSkill(Long id);
}
