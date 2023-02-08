/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.ProfessionalExperienceDTO;
import com.project.portfolioApi.Models.Enterprise;
import com.project.portfolioApi.Models.ProfessionalExperience;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IEnterpriseService;
import com.project.portfolioApi.Services.IProfessionalExperienceService;
import com.project.portfolioApi.Services.IUserService;
import java.util.ArrayList;
import java.util.Date;
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
public class ProfessionalExperienceController {
    
    @Autowired
    IProfessionalExperienceService interProExpServ;
    
    @Autowired
    IUserService interUserServ;
    
    @Autowired
    IEnterpriseService interEnterServ;
    
    @GetMapping("/professional_experience/get")
    @ResponseBody
    public List<ProfessionalExperienceDTO> getProfessionalExperiences(){
        List<ProfessionalExperience> proExp = interProExpServ.getProfessionalExperiences();
        List proExpDTO = new ArrayList();
        
        for(ProfessionalExperience p : proExp){
            proExpDTO.add(new ProfessionalExperienceDTO(p.getPosition(), p.getStartDate(), p.getEndDate(), p.getDescription()));
        }
        
        return proExpDTO;
    }
    
    @GetMapping("/professional_experience/get/{id}")
    public ProfessionalExperienceDTO getProfessionalExperienceById(@PathVariable Long id){
        ProfessionalExperience proExp = interProExpServ.getProfessionalExpById(id);
        
        if(proExp == null)
            return null;
        
        ProfessionalExperienceDTO proExpDTO = new ProfessionalExperienceDTO(proExp.getPosition(), proExp.getStartDate(), proExp.getEndDate(), proExp.getDescription());
        
        return proExpDTO;
    }
    
    @PostMapping("/professional_experience/create/{userId}/{enterpriseId}")
    public String ProfessionalExperience(@RequestBody ProfessionalExperience newProExp, @PathVariable Long userId, @PathVariable Long enterpriseId){
        
        User userTarget = interUserServ.getUserById(userId);
        if(userTarget == null)
            return "User not found";
        
        Enterprise enterpriseTarget = interEnterServ.getEnterpriseById(enterpriseId);
        if(enterpriseTarget == null)
            return "Enterprise not found";
        
        userTarget.getProfessionalExperiences().add(newProExp);
        enterpriseTarget.getProfessionalExperiences().add(newProExp);
        
        newProExp.setUser(userTarget);
        newProExp.getEnterprises().add(enterpriseTarget);
        interProExpServ.createProfessionalExp(newProExp);
        
        return "Professional Experience creation success!";
    }
    
    @PutMapping("/professional_experience/update/{id}")
    public ResponseEntity<String> updateProfessionalExperience(
            @PathVariable Long id,
            @RequestParam("position") String position,
            @RequestParam("startDate") Date startDate,
            @RequestParam("endDate") Date endDate,
            @RequestParam("description") String description){
        
        ProfessionalExperience proExpToUpdate = interProExpServ.getProfessionalExpById(id);
        
        if(proExpToUpdate == null)
            return new ResponseEntity<>("Professional Experience not found whit that ID", HttpStatus.NO_CONTENT);
        
        proExpToUpdate.setPosition(position);
        proExpToUpdate.setStartDate(startDate);
        proExpToUpdate.setEndDate(endDate);
        proExpToUpdate.setDescription(description);
        
        
        interProExpServ.createProfessionalExp(proExpToUpdate);
        
        return new ResponseEntity<>("Professional Experience successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/professional_experience/delete/{id}")
    public String deleteProfessionalExperience(@PathVariable Long id){
        
        interProExpServ.deleteProfessionalExp(id);
        
        return "Professional Experience deleted";
    }
}
