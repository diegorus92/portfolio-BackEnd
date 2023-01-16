/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Contact;
import com.project.portfolioApi.Repositories.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService implements IContactService{

    @Autowired
    ContactRepository contactRepo;
    
    @Override
    public void createContact(Contact newContact) {
        contactRepo.save(newContact);
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepo.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepo.deleteById(id);
    }
    
    
}
