/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Enterprise;
import java.util.List;


public interface IEnterpriseService {
    
    public void createEnterprise(Enterprise newEnterprise);
    public List<Enterprise> getEnterprises();
    public Enterprise getEnterpriseById(Long id);
    public void deleteEnterprise(Long id);
}
