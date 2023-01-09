
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
@Table(name="education")
@Getter @Setter
public class Education {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long educationId;
    
    private String degree;
    private String startDateYear;
    private String endDateYear;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Institution institution;
    
}
