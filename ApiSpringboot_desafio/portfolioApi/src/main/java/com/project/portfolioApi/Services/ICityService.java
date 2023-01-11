/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.City;
import java.util.List;


public interface ICityService {
    
    public void createCity(City newCity);
    public List<City> getCities();
    public City getCityById(Long id);
    public void deleteCity(Long id);
}
