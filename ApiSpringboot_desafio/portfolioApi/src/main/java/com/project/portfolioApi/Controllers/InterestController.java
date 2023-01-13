/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.Interest;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IInterestService;
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
public class InterestController {
    
    @Autowired
    IInterestService interInterestServ;
    
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/interest/get")
    @ResponseBody
    public List<Interest> getInterests(){
        List interests = interInterestServ.getInterests();
        
        return interests;
    }
    
    @GetMapping("/interest/get/{id}")
    public Interest getInterestById(@PathVariable Long id){
        Interest interest = interInterestServ.getInterestById(id);
        
        return interest;
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
