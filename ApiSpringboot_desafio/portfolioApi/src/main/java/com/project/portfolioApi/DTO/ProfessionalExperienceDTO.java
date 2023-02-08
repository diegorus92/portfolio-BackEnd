/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

import java.io.Serializable;
import java.util.Date;


public class ProfessionalExperienceDTO implements Serializable{
    
    private String position;
    private Date startDate;
    private Date endDate;
    private String description;

    public ProfessionalExperienceDTO(String position, Date startDate, Date endDate, String description) {
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }
    
    
}
