/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

import java.io.Serializable;


public class InstitutionDTO implements Serializable{
    
    private String name;
    private String logo;

    public InstitutionDTO(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }
    
    
}
