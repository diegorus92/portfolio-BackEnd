/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Reference;
import com.project.portfolioApi.Repositories.ReferenceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceService implements IReferenceService{
    
    @Autowired
    ReferenceRepository referenceRepo;

    @Override
    public void createReference(Reference newReference) {
        referenceRepo.save(newReference);
    }

    @Override
    public List<Reference> getReferences() {
        return referenceRepo.findAll();
    }

    @Override
    public Reference getReferenceById(Long id) {
        return referenceRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteReference(Long id) {
        referenceRepo.deleteById(id);
    }
}
