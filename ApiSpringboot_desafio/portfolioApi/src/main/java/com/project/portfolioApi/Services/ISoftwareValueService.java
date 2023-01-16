/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.SoftwareValue;
import java.util.List;

/**
 *
 * @author Educacion
 */
public interface ISoftwareValueService {
    
    public void createSoftwareValue(SoftwareValue newSoftwareValue);
    public List<SoftwareValue> getSoftwareValues();
    public SoftwareValue getSoftwareValueById(Long id);
    public void deleteSoftwareValue(Long id);
}
