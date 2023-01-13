/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="interests")
@Getter @Setter
public class Interest {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long interestId;
    
    private String description;
    private String label;
    
    @ManyToOne
    private User user;
}
