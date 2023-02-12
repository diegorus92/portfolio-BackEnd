/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.SkillTypeDTO;
import com.project.portfolioApi.Models.SkillType;
import com.project.portfolioApi.Services.ISkillTypeService;
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
public class SkillTypeController {
    
    @Autowired
    ISkillTypeService interSkillTypeServ;
    
    @GetMapping("/skilltypes/get")
    @ResponseBody
    public List<SkillTypeDTO> getSkillTypes(){
        List<SkillType> skillTypes = interSkillTypeServ.getSkillTypes();
        List<SkillTypeDTO> skillTypesDTO = new ArrayList();
        
        for(SkillType st : skillTypes){
            skillTypesDTO.add(new SkillTypeDTO(st.getType()));
        }
        
        return skillTypesDTO;
    }
    
    @GetMapping("/skilltype/get/{id}")
    public SkillTypeDTO getSkillTypeById(@PathVariable Long id){
        SkillType skillType = interSkillTypeServ.getSkillTypeById(id);
        
        if(skillType == null)
            return null;
        
        SkillTypeDTO skillTypeDTO = new SkillTypeDTO(skillType.getType());
        
        return skillTypeDTO;
    }
    
    @PostMapping("/skilltype/create")
    public String createSkillType(@RequestBody SkillType newSkillType){
        
        interSkillTypeServ.createSkillType(newSkillType);
        
        return "Skill Type creation success!";
    }
    
    @PutMapping("/skilltype/update/{id}")
    public ResponseEntity<String> updateSkillType(
            @PathVariable Long id,
            @RequestParam("type") String type
        ){
        
        SkillType skillTypeToUpdate = interSkillTypeServ.getSkillTypeById(id);
        
        if(skillTypeToUpdate == null)
            return new ResponseEntity<>("Skill Type not found whit that ID", HttpStatus.NO_CONTENT);
        
        skillTypeToUpdate.setType(type);
        
        
        interSkillTypeServ.createSkillType(skillTypeToUpdate);
        
        return new ResponseEntity<>("Skill Type successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/skilltype/delete/{id}")
    public String deleteSkill(@PathVariable Long id){
        
        interSkillTypeServ.deleteSkillType(id);
        
        return "Skill Type deleted";
    }
}
