/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

import java.io.Serializable;


public class EducationDTO implements Serializable{
    
    private String degree;
    private String startDateYear;
    private String endDateYear;

    public EducationDTO(String degree, String startDateYear, String endDateYear) {
        this.degree = degree;
        this.startDateYear = startDateYear;
        this.endDateYear = endDateYear;
    }

    public String getDegree() {
        return degree;
    }

    public String getStartDateYear() {
        return startDateYear;
    }

    public String getEndDateYear() {
        return endDateYear;
    }
    
    
}
