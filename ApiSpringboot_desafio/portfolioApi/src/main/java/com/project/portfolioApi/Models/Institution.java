
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
@Table(name="institutions")
@Getter @Setter
public class Institution {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long institutionId;
    
    private String name;
    private String logo;
    
    @OneToMany(mappedBy="institution")
    private List<Education> educationList;
    
    @OneToMany
    @JoinTable(name="Institutions_has_Cities",
            joinColumns=@JoinColumn(name="institutionId"),
            inverseJoinColumns=@JoinColumn(name="cityId"))
    List<City> cities;
}
