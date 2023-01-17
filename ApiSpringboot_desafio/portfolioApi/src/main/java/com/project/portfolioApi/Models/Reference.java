/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name="Reference")
@Getter @Setter
public class Reference {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long referenceId;
    
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String position;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="userId")
    private User user;
}
