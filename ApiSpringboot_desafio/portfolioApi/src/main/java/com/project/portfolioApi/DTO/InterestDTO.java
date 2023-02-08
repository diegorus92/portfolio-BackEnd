/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

import java.io.Serializable;


public class InterestDTO implements Serializable{
    
    private String description;
    private String label;

    public InterestDTO(String description, String label) {
        this.description = description;
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }
    
    
}
