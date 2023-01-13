/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.City;
import com.project.portfolioApi.Models.Enterprise;
import com.project.portfolioApi.Services.ICityService;
import com.project.portfolioApi.Services.IEnterpriseService;
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
public class EnterpriseController {
    
    @Autowired
    IEnterpriseService interEnterServ;
    
    @Autowired
    ICityService interCityServ;
    
    @GetMapping("/enterprise/get")
    @ResponseBody
    public List<Enterprise> getEnterprises(){
        List enterprises = interEnterServ.getEnterprises();
        
        return enterprises;
    }
    
    @GetMapping("/enterprise/get/{id}")
    public Enterprise getEnterpriseById(@PathVariable Long id){
        Enterprise enterprise = interEnterServ.getEnterpriseById(id);
        
        return enterprise;
    }
    
    @PostMapping("/enterprise/create/{cityId}")
    public String createEnterprise(@RequestBody Enterprise newEnterprise, @PathVariable Long cityId){
        
        City cityTarget = interCityServ.getCityById(cityId);
        if(cityTarget == null)
            return "City not found";
        
        cityTarget.getEnterprises().add(newEnterprise);
        newEnterprise.getCities().add(cityTarget);
        
        interEnterServ.createEnterprise(newEnterprise);
        
        return "Enterprise creation success!";
    }
    
    @PutMapping("/enterprise/update/{id}")
    public ResponseEntity<String> updateEnterprise(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("logo") String logo){
        
        Enterprise enterpriseToUpdate = interEnterServ.getEnterpriseById(id);
        
        if(enterpriseToUpdate == null)
            return new ResponseEntity<>("Enterprise not found whit that ID", HttpStatus.NO_CONTENT);
        
        enterpriseToUpdate.setName(name);
        enterpriseToUpdate.setLogo(logo);
        
        
        interEnterServ.createEnterprise(enterpriseToUpdate);
        
        return new ResponseEntity<>("Enterprise successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/enterprise/delete/{id}")
    public String deleteEnterprise(@PathVariable Long id){
        
        interEnterServ.deleteEnterprise(id);
        
        return "Enterprise deleted";
    }
}
