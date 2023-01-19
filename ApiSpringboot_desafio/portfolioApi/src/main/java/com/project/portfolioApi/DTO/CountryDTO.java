/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

import com.project.portfolioApi.Models.City;
import java.io.Serializable;
import java.util.List;


public class CountryDTO implements Serializable{
    
    private String name;
    private List<City> cities;

    public CountryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<City> getCities() {
        return cities;
    }
    
    
}
