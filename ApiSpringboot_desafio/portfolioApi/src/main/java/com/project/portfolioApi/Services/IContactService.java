/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Contact;
import java.util.List;


public interface IContactService {
    
    public void createContact(Contact newContact);
    public List<Contact> getContacts();
    public Contact getContactById(Long id);
    public void deleteContact(Long id);
}
