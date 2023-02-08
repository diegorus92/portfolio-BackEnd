/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.SkillType;
import java.util.List;


public interface ISkillTypeService {
    
    public void createSkillType(SkillType newSkillType);
    public List<SkillType> getSkillTypes();
    public SkillType getSkillTypeById(Long id);
    public void deleteSkillType(Long id);
}
