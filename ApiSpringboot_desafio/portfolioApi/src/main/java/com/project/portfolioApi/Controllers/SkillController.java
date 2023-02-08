/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.SkillDTO;
import com.project.portfolioApi.Models.Skill;
import com.project.portfolioApi.Services.ISkillService;
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
public class SkillController {
    
    @Autowired
    ISkillService interSkillServ;
    
    @GetMapping("/skills/get")
    @ResponseBody
    public List<SkillDTO> getSkills(){
        List<Skill> skills = interSkillServ.getSkills();
        List<SkillDTO> skillsDTO = new ArrayList();
        
        for(Skill s : skills){
            skillsDTO.add(new SkillDTO(s.getName(), s.getValue()));
        }
        
        return skillsDTO;
    }
    
    @GetMapping("/skill/get/{id}")
    public SkillDTO getSkillById(@PathVariable Long id){
        Skill skill = interSkillServ.getSkillById(id);
        
        if(skill == null)
            return null;
        
        SkillDTO skillDTO = new SkillDTO(skill.getName(), skill.getValue());
        
        return skillDTO;
    }
    
    @PostMapping("/skill/create")
    public String createSkill(@RequestBody Skill newSkill){
        
        interSkillServ.createSkill(newSkill);
        
        return "Skill creation success!";
    }
    
    @PutMapping("/skill/update/{id}")
    public ResponseEntity<String> updateSkill(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("value") int value
        ){
        
        Skill skillToUpdate = interSkillServ.getSkillById(id);
        
        if(skillToUpdate == null)
            return new ResponseEntity<>("Skill not found whit that ID", HttpStatus.NO_CONTENT);
        
        skillToUpdate.setName(name);
        skillToUpdate.setValue(value);
        
        
        interSkillServ.createSkill(skillToUpdate);
        
        return new ResponseEntity<>("Skill successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/skill/delete/{id}")
    public String deleteSkill(@PathVariable Long id){
        
        interSkillServ.deleteSkill(id);
        
        return "Skill deleted";
    }
}
