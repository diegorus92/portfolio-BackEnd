/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Institution;
import java.util.List;


public interface IInstitutionService {
   
    public void createInstitution(Institution newInstitution);
    public List<Institution> getInstitution();
    public Institution getInstitutionById(Long id);
    public void deleteInstitution(Long id);
}
