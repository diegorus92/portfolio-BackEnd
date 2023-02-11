/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.SocialNetDTO;
import com.project.portfolioApi.Models.SocialNet;
import com.project.portfolioApi.Models.SocialNetIcon;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.ISocialNetIconService;
import com.project.portfolioApi.Services.ISocialNetService;
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
public class SocialNetController {
    
    @Autowired
    ISocialNetService interSocialNetServ;
    
    @Autowired
    ISocialNetIconService interSNIServ;
    
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/socialnet/get")
    @ResponseBody
    public List<SocialNetDTO> getSocialNets(){
        List<SocialNet> socialNets = interSocialNetServ.getSocialNets();
        List<SocialNetDTO> socialNetsDTO = new ArrayList();
        
        for(SocialNet sn : socialNets)
            socialNetsDTO.add(new SocialNetDTO(sn.getIconName(), sn.getLink()));
        
        return socialNetsDTO;
    }
    
    @GetMapping("/socialnet/get/{id}")
    public SocialNetDTO getSocialNetById(@PathVariable Long id){
        SocialNet socialNet = interSocialNetServ.getSocialNetById(id);
        
        if(socialNet == null)
            return null;
        
        SocialNetDTO socialNetDTO = new SocialNetDTO(socialNet.getIconName(), socialNet.getLink());
        
        return socialNetDTO;
    }
    
    @PostMapping("/socialnet/create/{iconId}/{userId}")
    public String createSocialNetIcon(@RequestBody SocialNet newSocialNet, @PathVariable Long iconId, @PathVariable Long userId){
        
        SocialNetIcon socialNetIconTarget = interSNIServ.getSocialNetIconById(iconId);
        if(socialNetIconTarget == null)
            return "Social network icon not found";
        
        User userTarget = interUserServ.getUserById(userId);
        if(userTarget == null)
            return "User not found";
        
        socialNetIconTarget.getSocialNet().add(newSocialNet);
        newSocialNet.setSocialNetIcon(socialNetIconTarget);
        
        userTarget.getSocialNets().add(newSocialNet);
        newSocialNet.setUser(userTarget);
        
        interSocialNetServ.createSocialNet(newSocialNet);
        
        return "Social network creation success!";
    }
    
    @PutMapping("/socialnet/update/{id}")
    public ResponseEntity<String> updateSocialNet(
            @PathVariable Long id,
            @RequestParam("iconName") String name,
            @RequestParam("link") String link){
        
        
        SocialNet socialNetToUpdate = interSocialNetServ.getSocialNetById(id);
        if(socialNetToUpdate == null)
            return new ResponseEntity<>("Social network not found whit that ID", HttpStatus.NO_CONTENT);
        
        socialNetToUpdate.setIconName(name);
        socialNetToUpdate.setLink(link);
        interSocialNetServ.createSocialNet(socialNetToUpdate);
        
        return new ResponseEntity<>("Social network successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/socialnet/delete/{id}")
    public String deleteSocialNet(@PathVariable Long id){
        
        interSocialNetServ.deleteSocialNet(id);
        
        return "Social network deleted";
    }
}
