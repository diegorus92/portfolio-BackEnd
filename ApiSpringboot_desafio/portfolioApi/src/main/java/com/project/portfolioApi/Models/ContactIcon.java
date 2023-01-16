/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name="ContactIcons")
@Getter @Setter
public class ContactIcon {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long contactIconId;
    
    private String name;
    
    @OneToMany(mappedBy="contactIcon")
    private List<Contact> contacts;
}
