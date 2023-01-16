/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Software;
import java.util.List;


public interface ISoftwareService {
    
    public void createSoftware(Software newSoftware);
    public List<Software> getSoftwares();
    public Software getSoftwareById(Long id);
    public void deleteSoftware(Long id);
}
