/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.ContactIcon;
import com.project.portfolioApi.Services.IContactIconService;
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
public class ContactIconController {
    
    @Autowired
    IContactIconService interContactIconServ;
    
    @GetMapping("/contacticon/get")
    @ResponseBody
    public List<ContactIcon> getContactIcons(){
        List contactIcons = interContactIconServ.getContactIcons();
        
        return contactIcons;
    }
    
    @GetMapping("/contacticon/get/{id}")
    public ContactIcon getContactIconById(@PathVariable Long id){
        ContactIcon contactIcon = interContactIconServ.getContactIconById(id);
        
        return contactIcon;
    }
    
    @PostMapping("/contacticon/create")
    public String createContactIcon(@RequestBody ContactIcon newContactIcon){
        
        interContactIconServ.createContactIcon(newContactIcon);
        
        return "Contact Icon creation success!";
    }
    
    @PutMapping("/contacticon/update/{id}")
    public ResponseEntity<String> updateContactIcon(
            @PathVariable Long id,
            @RequestParam("name") String name){
        
        
        ContactIcon contactIconToUpdate = interContactIconServ.getContactIconById(id);
        if(contactIconToUpdate == null)
            return new ResponseEntity<>("Contact Icon not found whit that ID", HttpStatus.NO_CONTENT);
        
        contactIconToUpdate.setName(name);
        
        interContactIconServ.createContactIcon(contactIconToUpdate);
        
        return new ResponseEntity<>("Contact Icon successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/contacticon/delete/{id}")
    public String deleteContactIcon(@PathVariable Long id){
        
        interContactIconServ.deleteContactIcon(id);
        
        return "Contact Icon deleted";
    }
}
