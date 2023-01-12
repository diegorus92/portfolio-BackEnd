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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cities")
@Getter @Setter
public class City {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long cityId;
    
    private String name;
    
    @OneToMany
    @JoinTable(name="Institutions_has_Cities",
            joinColumns=@JoinColumn(name="cityId"),
            inverseJoinColumns=@JoinColumn(name="institutionId"))
    private List<Institution> institutions;
    
    @ManyToOne
    private Country country;
    
    @OneToMany
    @JoinTable(name="Enterprises_has_Cities",
            joinColumns=@JoinColumn(name="cityId"),
            inverseJoinColumns=@JoinColumn(name="enterpriseId"))
    private List<Enterprise> enterprises;
}
