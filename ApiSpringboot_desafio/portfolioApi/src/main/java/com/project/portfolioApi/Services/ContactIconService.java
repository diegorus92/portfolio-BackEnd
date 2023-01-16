/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.ContactIcon;
import com.project.portfolioApi.Repositories.ContactIconRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactIconService implements IContactIconService{

    @Autowired
    ContactIconRepository contactIconRepo;
    
    @Override
    public void createContactIcon(ContactIcon newContactIcon) {
        contactIconRepo.save(newContactIcon);
    }

    @Override
    public List<ContactIcon> getContactIcons() {
        return contactIconRepo.findAll();
    }

    @Override
    public ContactIcon getContactIconById(Long id) {
        return contactIconRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteContactIcon(Long id) {
        contactIconRepo.deleteById(id);
    }
    
}
