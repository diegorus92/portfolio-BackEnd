
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Country;
import java.util.List;


public interface ICountryService {
    
    public void createCountry(Country newCountry);
    public List<Country> getCountries();
    public Country getCountryById(Long id);
    public void deleteCountry(Long id);
}
