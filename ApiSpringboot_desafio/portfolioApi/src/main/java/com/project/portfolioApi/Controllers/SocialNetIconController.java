/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.SocialNetIconDTO;
import com.project.portfolioApi.Models.SocialNetIcon;
import com.project.portfolioApi.Services.ISocialNetIconService;
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
public class SocialNetIconController {
    
    @Autowired
    ISocialNetIconService interSNIServ;
    
    @GetMapping("/socialneticon/get")
    @ResponseBody
    public List<SocialNetIconDTO> getSocialNetIcons(){
        List<SocialNetIcon> socialNetIcons = interSNIServ.getSocialNetIcons();
        List<SocialNetIconDTO> socialNetIconsDTO = new ArrayList();
        
        for(SocialNetIcon sni : socialNetIcons)
            socialNetIconsDTO.add(new SocialNetIconDTO(sni.getName()));
        
        return socialNetIconsDTO;
    }
    
    @GetMapping("/socialneticon/get/{id}")
    public SocialNetIconDTO getSocialNetIconById(@PathVariable Long id){
        SocialNetIcon socialNetIcon = interSNIServ.getSocialNetIconById(id);
        
        if(socialNetIcon == null)
            return null;
        
        SocialNetIconDTO socialNetIconDTO = new SocialNetIconDTO(socialNetIcon.getName());
        
        return socialNetIconDTO;
    }
    
    @PostMapping("/socialneticon/create")
    public String createSocialNetIcon(@RequestBody SocialNetIcon newSocialNetIcon){
        
        interSNIServ.createSocialNetIcon(newSocialNetIcon);
        
        return "Social network icon creation success!";
    }
    
    @PutMapping("/socialneticon/update/{id}")
    public ResponseEntity<String> updateSocialNetIcon(
            @PathVariable Long id,
            @RequestParam("name") String name){
        
        
        SocialNetIcon socialNetIconToUpdate = interSNIServ.getSocialNetIconById(id);
        if(socialNetIconToUpdate == null)
            return new ResponseEntity<>("Social network icon not found whit that ID", HttpStatus.NO_CONTENT);
        
        socialNetIconToUpdate.setName(name);
        interSNIServ.createSocialNetIcon(socialNetIconToUpdate);
        
        return new ResponseEntity<>("Social network icon successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/socialneticon/delete/{id}")
    public String deleteSocialNetIcon(@PathVariable Long id){
        
        interSNIServ.deleteSocialNetIcon(id);
        
        return "Social network icon deleted";
    }
}
