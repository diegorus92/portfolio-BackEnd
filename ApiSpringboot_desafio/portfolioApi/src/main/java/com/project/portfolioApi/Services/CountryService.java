
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Country;
import com.project.portfolioApi.Repositories.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements ICountryService{

    @Autowired
    CountryRepository countryRepo;
    
    @Override
    public void createCountry(Country newCountry) {
        countryRepo.save(newCountry);
    }

    @Override
    public List<Country> getCountries(){ 
            return countryRepo.findAll();
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepo.deleteById(id);
    }
    
}
