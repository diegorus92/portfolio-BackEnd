
package com.project.portfolioApi.Models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="enterprises")
@Getter @Setter
public class Enterprise {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long enterpriseId;
    
    private String name;
    private String logo;
    
    @OneToMany
    @JoinTable(name="Enterprises_has_Cities",
            joinColumns=@JoinColumn(name="enterpriseId"),
            inverseJoinColumns=@JoinColumn(name="cityId"))
    private List<City> cities;
    
    @OneToMany
    @JoinTable(name="ProfessionalExperience_has_Enterprise",
            joinColumns=@JoinColumn(name="enterpriseId"),
            inverseJoinColumns=@JoinColumn(name="professionalExpId"))
    private List<ProfessionalExperience> professionalExperiences;
}
