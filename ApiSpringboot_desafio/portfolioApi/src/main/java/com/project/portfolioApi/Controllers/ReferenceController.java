/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.Reference;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IReferenceService;
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
public class ReferenceController {
    
    @Autowired
    IReferenceService interReferenceServ;
    
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/reference/get")
    @ResponseBody
    public List<Reference> getReferences(){
        List references = interReferenceServ.getReferences();
        
        return references;
    }
    
    @GetMapping("/reference/get/{id}")
    public Reference getReferenceById(@PathVariable Long id){
        Reference reference = interReferenceServ.getReferenceById(id);
        
        return reference;
    }
    
    @PostMapping("/reference/create/{userId}")
    public String createReference(@RequestBody Reference newReference,
                                @PathVariable Long userId){
        
        User userTarget = interUserServ.getUserById(userId);
        if(userTarget == null)
            return "User not found";
        
        userTarget.setReference(newReference);
        
        newReference.setUser(userTarget);
        
        interReferenceServ.createReference(newReference);
        
        return "Reference creation success!";
    }
    
    @PutMapping("/reference/update/{id}")
    public ResponseEntity<String> updateReference(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("position") String position){
        
        
        Reference referenceToUpdate = interReferenceServ.getReferenceById(id);
        if(referenceToUpdate == null)
            return new ResponseEntity<>("Reference not found whit that ID", HttpStatus.NO_CONTENT);
        
        referenceToUpdate.setName(name);
        referenceToUpdate.setSurname(surname);
        referenceToUpdate.setPhone(phone);
        referenceToUpdate.setEmail(email);
        referenceToUpdate.setPosition(position);
        
        interReferenceServ.createReference(referenceToUpdate);
        
        return new ResponseEntity<>("Reference successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/reference/delete/{id}")
    public String deleteReference(@PathVariable Long id){
        
        interReferenceServ.deleteReference(id);
        
        return "Reference deleted";
    }
}
