
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.Country;
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
public class CountryController {
    
    @Autowired
    ICountryService interCountryServ;
    
    @GetMapping("/country/get")
    @ResponseBody
    public List<Country> getCountries(){
        List countries = interCountryServ.getCountries();
        
        return countries;
    }
    
    @GetMapping("/country/get/{id}")
    public Country getCountryById(@PathVariable Long id){
        Country country = interCountryServ.getCountryById(id);
        
        return country;
    }
    
    @PostMapping("/country/create")
    public String createInstitution(@RequestBody Country newCountry){
        
        interCountryServ.createCountry(newCountry);
        
        return "City creation success!";
    }
    
    @PutMapping("/country/update/{id}")
    public ResponseEntity<String> updateCountry(
            @PathVariable Long id,
            @RequestParam("name") String name){
        
        Country countryToUpdate = interCountryServ.getCountryById(id);
        
        if(countryToUpdate == null)
            return new ResponseEntity<>("Country not found whit that ID", HttpStatus.NO_CONTENT);
        
        countryToUpdate.setName(name);
        
        
        interCountryServ.createCountry(countryToUpdate);
        
        return new ResponseEntity<>("Country successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/country/delete/{id}")
    public String deleteCountry(@PathVariable Long id){
        
        interCountryServ.deleteCountry(id);
        
        return "Country deleted";
    }
}
