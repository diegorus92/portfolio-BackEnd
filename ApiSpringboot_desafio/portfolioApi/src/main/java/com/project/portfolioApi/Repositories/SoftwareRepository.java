/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Repositories;

import com.project.portfolioApi.Models.Software;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Educacion
 */
public interface SoftwareRepository extends JpaRepository<Software, Long>{
    
}
