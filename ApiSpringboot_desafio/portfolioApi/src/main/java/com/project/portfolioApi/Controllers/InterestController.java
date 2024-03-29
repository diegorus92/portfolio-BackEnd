/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.InterestDTO;
import com.project.portfolioApi.Models.Interest;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IInterestService;
import com.project.portfolioApi.Services.IUserService;
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
public class InterestController {
    
    @Autowired
    IInterestService interInterestServ;
    
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/interest/get")
    @ResponseBody
    public List<InterestDTO> getInterests(){
        List<Interest> interests = interInterestServ.getInterests();
        List<InterestDTO> interestsDTO = new ArrayList();
        
        for(Interest i : interests){
            interestsDTO.add(new InterestDTO(i.getDescription(), i.getLabel()));
        }
        
        return interestsDTO;
    }
    
    @GetMapping("/interest/get/{id}")
    public InterestDTO getInterestById(@PathVariable Long id){
        Interest interest = interInterestServ.getInterestById(id);
        
        if(interest == null)
            return null;
            
        InterestDTO interestDTO = new InterestDTO(interest.getDescription(), interest.getLabel());
        
        return interestDTO;
    }
    
    @PostMapping("/interest/create/{userId}")
    public String createInterest(@RequestBody Interest newInterest, @PathVariable Long userId){
        
        User userTarget = interUserServ.getUserById(userId);
        if(userTarget == null)
            return "User not found";
        
        userTarget.getInterests().add(newInterest);
        newInterest.setUser(userTarget);
        interInterestServ.createInterest(newInterest);
        
        return "Interest creation success!";
    }
    
    @PutMapping("/interest/update/{id}")
    public ResponseEntity<String> updateInterest(
            @PathVariable Long id,
            @RequestParam("description") String description,
            @RequestParam("label") String label){
        
        Interest interestToUpdate = interInterestServ.getInterestById(id);
        
        if(interestToUpdate == null)
            return new ResponseEntity<>("Interest not found whit that ID", HttpStatus.NO_CONTENT);
        
        interestToUpdate.setDescription(description);
        interestToUpdate.setLabel(label);
        
        
        interInterestServ.createInterest(interestToUpdate);
        
        return new ResponseEntity<>("Interest successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/interest/delete/{id}")
    public String deleteInterest(@PathVariable Long id){
        
        interInterestServ.deleteInterest(id);
        
        return "Interest deleted";
    }
}
