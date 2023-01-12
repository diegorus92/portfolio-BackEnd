/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Enterprise;
import com.project.portfolioApi.Repositories.EnterpriseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseService implements IEnterpriseService{
    
    @Autowired
    EnterpriseRepository enterpriseRepo;

    @Override
    public void createEnterprise(Enterprise newEnterprise) {
        enterpriseRepo.save(newEnterprise);
    }

    @Override
    public List<Enterprise> getEnterprises() {
        return enterpriseRepo.findAll();
    }

    @Override
    public Enterprise getEnterpriseById(Long id) {
        return enterpriseRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteEnterprise(Long id) {
        enterpriseRepo.deleteById(id);
    }
}
