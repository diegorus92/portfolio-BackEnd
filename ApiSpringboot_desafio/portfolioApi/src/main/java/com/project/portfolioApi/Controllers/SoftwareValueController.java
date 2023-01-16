/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.SoftwareValue;
import com.project.portfolioApi.Services.ISoftwareValueService;
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
public class SoftwareValueController {
    
    @Autowired
    ISoftwareValueService interSoftwareValueServ;
    
    @GetMapping("/softwarevalue/get")
    @ResponseBody
    public List<SoftwareValue> getSoftwareValues(){
        List softwareValues = interSoftwareValueServ.getSoftwareValues();
        
        return softwareValues;
    }
    
    @GetMapping("/softwarevalue/get/{id}")
    public SoftwareValue getSoftwareValueById(@PathVariable Long id){
        SoftwareValue softwareValue = interSoftwareValueServ.getSoftwareValueById(id);
        
        return softwareValue;
    }
    
    @PostMapping("/softwarevalue/create")
    public String createSoftwareValue(@RequestBody SoftwareValue newSoftwareValue){
        
        interSoftwareValueServ.createSoftwareValue(newSoftwareValue);
        
        return "Software Value creation success!";
    }
    
    @PutMapping("/softwarevalue/update/{id}")
    public ResponseEntity<String> updateSoftwareValue(
            @PathVariable Long id,
            @RequestParam("value") String value){
        
        
        SoftwareValue SoftwareValueToUpdate = interSoftwareValueServ.getSoftwareValueById(id);
        if(SoftwareValueToUpdate == null)
            return new ResponseEntity<>("Software Value not found whit that ID", HttpStatus.NO_CONTENT);
        
        SoftwareValueToUpdate.setValue(value);
        
        interSoftwareValueServ.createSoftwareValue(SoftwareValueToUpdate);
        
        return new ResponseEntity<>("Software Value successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/softwarevalue/delete/{id}")
    public String deleteSoftwareValue(@PathVariable Long id){
        
        interSoftwareValueServ.deleteSoftwareValue(id);
        
        return "Software Value deleted";
    }
}
