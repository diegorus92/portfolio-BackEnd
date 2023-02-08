
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.EducationDTO;
import com.project.portfolioApi.Models.Education;
import com.project.portfolioApi.Models.Institution;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IEducationService;
import com.project.portfolioApi.Services.IInstitutionService;
import com.project.portfolioApi.Services.IUserService;
import java.util.ArrayList;
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
public class EducationController {
    
    @Autowired
    IEducationService interEduServ;
    
    @Autowired
    IUserService interUserServ;
    
    @Autowired
    IInstitutionService interInstiServ;
    
    @GetMapping("/educations/get")
    @ResponseBody
    public List<EducationDTO> getEducations(){
        List<Education> educations = interEduServ.getEducation();
        List<EducationDTO> educationsDTO = new ArrayList();
        
        for(Education e : educations){
            educationsDTO.add(new EducationDTO(e.getDegree(), e.getStartDateYear(), e.getEndDateYear()));
        }
        
        return educationsDTO;
    }
    
    @GetMapping("/education/get/{id}")
    public EducationDTO getEducationById(@PathVariable Long id){
        Education education = interEduServ.getEducationById(id);
        
        if(education == null)
            return null;
        
        EducationDTO educationDTO = new EducationDTO(education.getDegree(), education.getStartDateYear(), education.getEndDateYear());
        
        return educationDTO;
    }
    
    @PostMapping("/education/create/{userId}/{institutionId}")
    public String createEducation(@RequestBody Education newEducation,
            @PathVariable Long userId,
            @PathVariable Long institutionId){
        
        //Se agrega la nueva instancia de Educacion en las listas correspondientes 
        //cada clase de lado "Uno"
        User targetUser = interUserServ.getUserById(userId);
        targetUser.getEducationList().add(newEducation);
        
        Institution targetInsti = interInstiServ.getInstitutionById(institutionId);
        targetInsti.getEducationList().add(newEducation);
        //////////////////////////////////////////////////////////////////////
        
        //Se agregan las instancias de cada clase de lado "Uno" en ésta de
        //lado "Muchos" en sus respectiva propiedades
        newEducation.setUser(targetUser);
        newEducation.setInstitution(targetInsti);
        interEduServ.createEducation(newEducation);
        
        return "Education creation success!";
    }
    
    @PutMapping("/education/update/{id}")
    public ResponseEntity<String> updateEducation(
            @PathVariable Long id,
            @RequestParam("degree") String degree,
            @RequestParam("startDateYear") String startYear,
            @RequestParam("endDateYear") String endYear){
        
        Education eduToUpdate = interEduServ.getEducationById(id);
        
        if(eduToUpdate == null)
            return new ResponseEntity<>("Education not found whit that ID", HttpStatus.NO_CONTENT);
        
        eduToUpdate.setDegree(degree);
        eduToUpdate.setStartDateYear(startYear);
        eduToUpdate.setEndDateYear(endYear);
        
        
        interEduServ.createEducation(eduToUpdate);
        
        return new ResponseEntity<>("Education successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/education/delete/{id}")
    public String deleteEducation(@PathVariable Long id){
        
        interEduServ.deleteEducation(id);
        
        return "Education deleted";
    }
}
