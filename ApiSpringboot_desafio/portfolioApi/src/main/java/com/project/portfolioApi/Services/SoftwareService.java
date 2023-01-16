/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Software;
import com.project.portfolioApi.Repositories.SoftwareRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftwareService implements ISoftwareService{
    
    @Autowired
    SoftwareRepository softwareRepo;

    @Override
    public void createSoftware(Software newSoftware) {
        softwareRepo.save(newSoftware);
    }

    @Override
    public List<Software> getSoftwares() {
        return softwareRepo.findAll();
    }

    @Override
    public Software getSoftwareById(Long id) {
        return softwareRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSoftware(Long id) {
        softwareRepo.deleteById(id);
    }
}
