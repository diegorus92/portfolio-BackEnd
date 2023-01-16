/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.SoftwareValue;
import com.project.portfolioApi.Repositories.SoftwareValueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftwareValueService implements ISoftwareValueService{
    
    @Autowired
    SoftwareValueRepository softwareValueRepo;

    @Override
    public void createSoftwareValue(SoftwareValue newSoftwareValue) {
        softwareValueRepo.save(newSoftwareValue);
    }

    @Override
    public List<SoftwareValue> getSoftwareValues() {
        return softwareValueRepo.findAll();
    }

    @Override
    public SoftwareValue getSoftwareValueById(Long id) {
        return softwareValueRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSoftwareValue(Long id) {
        softwareValueRepo.deleteById(id);
    }
}
