/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Education;
import java.util.List;

/**
 *
 * @author Educacion
 */
public interface IEducationService {
    
    public void createEducation(Education newEducation);
    public List<Education> getEducation();
    public Education getEducationById(Long id);
    public void deleteEducation(Long id);
}
