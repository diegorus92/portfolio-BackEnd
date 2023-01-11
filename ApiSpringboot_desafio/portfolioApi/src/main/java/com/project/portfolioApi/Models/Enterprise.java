
package com.project.portfolioApi.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
