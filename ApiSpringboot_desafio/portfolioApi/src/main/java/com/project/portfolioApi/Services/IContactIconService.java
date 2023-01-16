/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.ContactIcon;
import java.util.List;


public interface IContactIconService {
    
    public void createContactIcon(ContactIcon newContactIcon);
    public List<ContactIcon> getContactIcons();
    public ContactIcon getContactIconById(Long id);
    public void deleteContactIcon(Long id);
}
