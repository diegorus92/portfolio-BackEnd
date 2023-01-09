/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.Institution;
import com.project.portfolioApi.Services.IInstitutionService;
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
public class InstitutionController {
    
    @Autowired
    IInstitutionService interInstiServ;
    
    @GetMapping("/institution/get")
    @ResponseBody
    public List<Institution> getInstitutions(){
        List institutions = interInstiServ.getInstitution();
        
        return institutions;
    }
    
    @GetMapping("/institution/get/{id}")
    public Institution getInstitutionById(@PathVariable Long id){
        Institution institution = interInstiServ.getInstitutionById(id);
        
        return institution;
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
    
    @DeleteMapping("/institution/delete/{id}")
    public String deleteInstitution(@PathVariable Long id){
        
        interInstiServ.deleteInstitution(id);
        
        return "Institution deleted";
    }
}
