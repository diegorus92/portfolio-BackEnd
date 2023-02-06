/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

import java.io.Serializable;
import java.util.List;


public class CountryCitiesDTO implements Serializable{
    
    private String countryName;
    private List<CityDTO>citiesOfCountry;
    
    public CountryCitiesDTO(String countryName, List<CityDTO>cities){
        this.countryName = countryName;
        this.citiesOfCountry = cities;
    }

    public String getCountryName() {
        return countryName;
    }

    public List<CityDTO> getCitiesOfCountry() {
        return citiesOfCountry;
    }
    
    
}
