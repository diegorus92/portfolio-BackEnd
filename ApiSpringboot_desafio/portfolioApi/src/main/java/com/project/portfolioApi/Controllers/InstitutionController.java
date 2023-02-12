/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.InstitutionDTO;
import com.project.portfolioApi.Models.City;
import com.project.portfolioApi.Models.Institution;
import com.project.portfolioApi.Services.ICityService;
import com.project.portfolioApi.Services.IInstitutionService;
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
public class InstitutionController {
    
    @Autowired
    IInstitutionService interInstiServ;
    
    @Autowired
    ICityService interCityServ;
    
    @GetMapping("/institution/get")
    @ResponseBody
    public List<InstitutionDTO> getInstitutions(){
        List<Institution> institutions = interInstiServ.getInstitution();
        List<InstitutionDTO> institutionsDTO = new ArrayList();
        
        for(Institution i : institutions){
            institutionsDTO.add(new InstitutionDTO(i.getName(), i.getLogo()));
        }
        
        return institutionsDTO;
    }
    
    @GetMapping("/institution/get/{id}")
    public InstitutionDTO getInstitutionById(@PathVariable Long id){
        Institution institution = interInstiServ.getInstitutionById(id);
        
        if(institution == null)
            return null;
        
        InstitutionDTO institutionDTO = new InstitutionDTO(institution.getName(), institution.getLogo());
        
        return institutionDTO;
    }
    
    @PostMapping("/institution/create")
    public String createInstitution(@RequestBody Institution newInstitution){
        
        interInstiServ.createInstitution(newInstitution);
        
        return "Education creation success!";
    }
    
    @PutMapping("/institution/update/{id}")
    public ResponseEntity<String> updateInstitution(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("logo") String logo){
        
        Institution instiToUpdate = interInstiServ.getInstitutionById(id);
        
        if(instiToUpdate == null)
            return new ResponseEntity<>("Institution not found whit that ID", HttpStatus.NO_CONTENT);
        
        instiToUpdate.setName(name);
        instiToUpdate.setLogo(logo);
        
        
        interInstiServ.createInstitution(instiToUpdate);
        
        return new ResponseEntity<>("Education successfuly updated", HttpStatus.OK);
    }
    
    @PutMapping("institution/{institutionId}/relationship/{cityId}")
    public ResponseEntity<String> relateInstitutionWithCity(@PathVariable Long institutionId, @PathVariable Long cityId){
        
        Institution insti = interInstiServ.getInstitutionById(institutionId);
        City city = interCityServ.getCityById(cityId);
        
        if(insti == null)
            return new ResponseEntity("Institution not found", HttpStatus.NO_CONTENT);
        
        if(city == null)
            return new ResponseEntity("Institution not found", HttpStatus.NO_CONTENT);
        
        insti.getCities().add(city);
        city.getInstitutions().add(insti);
        
        interInstiServ.createInstitution(insti);
        interCityServ.createCity(city);
        
        return new ResponseEntity("Institution has been related with a City", HttpStatus.OK);
    }
    
    @DeleteMapping("/institution/delete/{id}")
    public String deleteInstitution(@PathVariable Long id){
        
        interInstiServ.deleteInstitution(id);
        
        return "Institution deleted";
    }
}
