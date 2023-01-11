/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.City;
import com.project.portfolioApi.Repositories.CityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService{

    @Autowired
    CityRepository cityRepo;
    
    @Override
    public void createCity(City newCity) {
        cityRepo.save(newCity);
    }

    @Override
    public List<City> getCities() {
        return cityRepo.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepo.deleteById(id);
    }
    
}
