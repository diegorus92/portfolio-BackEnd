/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.Contact;
import com.project.portfolioApi.Models.ContactIcon;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IContactIconService;
import com.project.portfolioApi.Services.IContactService;
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
public class ContactController {
    
    @Autowired
    IContactService interContactServ;
    
    @Autowired
    IContactIconService interContactIconServ;
    
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/contact/get")
    @ResponseBody
    public List<Contact> getContacts(){
        List contacts = interContactServ.getContacts();
        
        return contacts;
    }
    
    @GetMapping("/contact/get/{id}")
    public Contact getContactById(@PathVariable Long id){
        Contact contact = interContactServ.getContactById(id);
        
        return contact;
    }
    
    @PostMapping("/contact/create/{contactIconId}/{userId}")
    public String createContact(@RequestBody Contact newContact,
                                @PathVariable Long contactIconId,
                                @PathVariable Long userId){
        
        
        ContactIcon iconTarget = interContactIconServ.getContactIconById(contactIconId);
        if(iconTarget == null)
            return "ContactIcon not found";
        
        User userTarget = interUserServ.getUserById(userId);
        if(userTarget == null)
            return "User not found";
        
        iconTarget.getContacts().add(newContact);
        userTarget.getContacts().add(newContact);
        
        newContact.setContactIcon(iconTarget);
        newContact.setUser(userTarget);
        
        interContactServ.createContact(newContact);
        
        return "Contact creation success!";
    }
    
    @PutMapping("/contact/update/{id}")
    public ResponseEntity<String> updateContact(
            @PathVariable Long id,
            @RequestParam("data") String data){
        
        
        Contact contactToUpdate = interContactServ.getContactById(id);
        if(contactToUpdate == null)
            return new ResponseEntity<>("Contact not found whit that ID", HttpStatus.NO_CONTENT);
        
        contactToUpdate.setData(data);
        
        interContactServ.createContact(contactToUpdate);
        
        return new ResponseEntity<>("Contact successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/contact/delete/{id}")
    public String deleteContact(@PathVariable Long id){
        
        interContactServ.deleteContact(id);
        
        return "Contact deleted";
    }
}
