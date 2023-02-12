
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.CityDTO;
import com.project.portfolioApi.DTO.CountryCitiesDTO;
import com.project.portfolioApi.DTO.CountryDTO;
import com.project.portfolioApi.Models.City;
import com.project.portfolioApi.Models.Country;
import com.project.portfolioApi.Services.ICityService;
import com.project.portfolioApi.Services.ICountryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CountryController {
    
    @Autowired
    ICountryService interCountryServ;

    
    @GetMapping("/country/get")
    @ResponseBody
    public List<CountryDTO> getCountries(){
        List <Country> countries = interCountryServ.getCountries();
        List<CountryDTO> countriesDto = new ArrayList();
        
        for(Country c : countries){
            countriesDto.add(new CountryDTO(c.getName()));
        }
        
        return countriesDto;
    }
    
    //Para devolver la lista de ciudades relacionadas al país correspondiente al ID ingresado
    /*@GetMapping("/country/get/cities/{countryId}")
    @ResponseBody
    public List<CityDTO> citiesOfCountry(@PathVariable Long countryId){
        Country c = interCountryServ.getCountryById(countryId);
        List<CityDTO> citiesOfCountry = new ArrayList();

        for(City cty : c.getCities()){
            citiesOfCountry.add(new CityDTO(cty.getName()));
        }

        return citiesOfCountry;
    }*/
    
    @GetMapping("/country/get/cities/{countryId}")
    @ResponseBody
    public CountryCitiesDTO citiesOfCountry(@PathVariable Long countryId){
        Country c = interCountryServ.getCountryById(countryId);
        List<CityDTO> citiesOfCountry = new ArrayList();

        for(City cty : c.getCities()){
            citiesOfCountry.add(new CityDTO(cty.getName()));
        }
        
        CountryCitiesDTO ccdto = new CountryCitiesDTO(c.getName(), citiesOfCountry);

        return ccdto;
    }
    
    @GetMapping("/country/get/{id}")
    public CountryDTO getCountryById(@PathVariable Long id){
        Country country = interCountryServ.getCountryById(id);
        CountryDTO countryDto = new CountryDTO(country.getName());
        
        return countryDto;
    }
    
    @PostMapping("/country/create")
    public String createCountry(@RequestBody Country newCountry){
        
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
