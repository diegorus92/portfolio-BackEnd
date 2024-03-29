/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ProfessionalExperience")
@Getter @Setter
public class ProfessionalExperience {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long professionalExpId;
    
    private String position;
    private Date startDate;
    private Date endDate;
    private String description;
    
    @ManyToOne
    private User user;
    
    @OneToMany
    @JoinTable(name="ProfessionalExperience_has_Enterprise",
            joinColumns=@JoinColumn(name="professionalExpId"),
            inverseJoinColumns=@JoinColumn(name="enterpriseId"))
    private List<Enterprise> enterprises;
}
