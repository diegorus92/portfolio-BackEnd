/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.ProfessionalExperience;
import java.util.List;


public interface IProfessionalExperienceService {
    
    public void createProfessionalExp(ProfessionalExperience newProfessionalExp);
    public List<ProfessionalExperience> getProfessionalExperiences();
    public ProfessionalExperience getProfessionalExpById(Long id);
    public void deleteProfessionalExp(Long id);
}
