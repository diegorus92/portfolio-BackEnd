
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.City;
import com.project.portfolioApi.Models.Country;
import com.project.portfolioApi.Services.ICityService;
import com.project.portfolioApi.Services.ICountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    
    @Autowired
    ICityService interCityServ;
    
    @Autowired 
    ICountryService interCountryServ;
    
    @GetMapping("/city/get")
    @ResponseBody
    public List<City> getCities(){
        List cities = interCityServ.getCities();
        
        return cities;
    }
    
    @GetMapping("/city/get/{id}")
    public City getCityById(@PathVariable Long id){
        City city = interCityServ.getCityById(id);
        
        return city;
    }
    
    @PostMapping("/city/create/{countryId}")
    public String createInstitution(@RequestBody City newCity, @PathVariable Long countryId){
        
        Country countryTarget = interCountryServ.getCountryById(countryId);
        if(countryTarget == null)
            return "Country not found";
        
        countryTarget.getCities().add(newCity);
        
        newCity.setCountry(countryTarget);
        
        interCityServ.createCity(newCity);
        
        return "City creation success!";
    }
    
    @PutMapping("/city/update/{id}")
    public ResponseEntity<String> updateCity(
            @PathVariable Long id,
            @RequestParam("name") String name){
        
        City cityToUpdate = interCityServ.getCityById(id);
        
        if(cityToUpdate == null)
            return new ResponseEntity<>("City not found whit that ID", HttpStatus.NO_CONTENT);
        
        cityToUpdate.setName(name);
        
        
        interCityServ.createCity(cityToUpdate);
        
        return new ResponseEntity<>("City successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/city/delete/{id}")
    public String deleteCity(@PathVariable Long id){
        
        interCityServ.deleteCity(id);
        
        return "City deleted";
    }
}
