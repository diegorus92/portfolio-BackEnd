/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Reference;
import java.util.List;

/**
 *
 * @author Educacion
 */
public interface IReferenceService {
    
    public void createReference(Reference newReference);
    public List<Reference> getReferences();
    public Reference getReferenceById(Long id);
    public void deleteReference(Long id);
}
