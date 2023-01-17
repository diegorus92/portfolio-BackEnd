/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.Software;
import com.project.portfolioApi.Models.SoftwareValue;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.ISoftwareService;
import com.project.portfolioApi.Services.ISoftwareValueService;
import com.project.portfolioApi.Services.IUserService;
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
public class SoftwareController {
    
    @Autowired
    ISoftwareService interSoftwareServ;
    
    @Autowired
    ISoftwareValueService interSoftwareValueServ;
    
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/software/get")
    @ResponseBody
    public List<Software> getSoftwares(){
        List softwares = interSoftwareServ.getSoftwares();
        
        return softwares;
    }
    
    @GetMapping("/software/get/{id}")
    public Software getSoftwareById(@PathVariable Long id){
        Software software = interSoftwareServ.getSoftwareById(id);
        
        return software;
    }
    
    @PostMapping("/software/create/{softwareValueId}/{userId}")
    public String createSoftware(@RequestBody Software newSoftware,
                                @PathVariable Long softwareValueId,
                                @PathVariable Long userId){
        
        SoftwareValue softwareValueTarget = interSoftwareValueServ.getSoftwareValueById(softwareValueId);
        if(softwareValueTarget == null)
            return "Software Value not found";
        
        User userTarget = interUserServ.getUserById(userId);
        if(userTarget == null)
            return "User not found";
        
        softwareValueTarget.getSoftwares().add(newSoftware);
        userTarget.getSoftwares().add(newSoftware);
        
        newSoftware.setSoftwareValue(softwareValueTarget);
        newSoftware.setUser(userTarget);
        
        interSoftwareServ.createSoftware(newSoftware);
        
        return "Software creation success!";
    }
    
    @PutMapping("/software/update/{id}")
    public ResponseEntity<String> updateSoftware(
            @PathVariable Long id,
            @RequestParam("name") String name){
        
        
        Software SoftwareToUpdate = interSoftwareServ.getSoftwareById(id);
        if(SoftwareToUpdate == null)
            return new ResponseEntity<>("Software not found whit that ID", HttpStatus.NO_CONTENT);
        
        SoftwareToUpdate.setName(name);
        
        interSoftwareServ.createSoftware(SoftwareToUpdate);
        
        return new ResponseEntity<>("Software successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/software/delete/{id}")
    public String deleteSoftware(@PathVariable Long id){
        
        interSoftwareServ.deleteSoftware(id);
        
        return "Software deleted";
    }
}
