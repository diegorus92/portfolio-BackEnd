
package com.project.portfolioApi.Models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter @Setter
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    
    private String name;
    private String surname;
    private String nickname;
    private String password;
    private String position;
    private String description;
    private String bannerSrc;
    private String profileImageSrc;
    
    @OneToMany(mappedBy="user")
    private List<Education> educationList;
    
    @OneToMany(mappedBy="user")
    private List<ProfessionalExperience> professionalExperiences;
    
    @OneToMany(mappedBy="user")
    private List<Interest> interests;
    
    @OneToMany(mappedBy="user")
    private List<Idiom> idioms;
    
    @OneToMany(mappedBy="user")
    private List<SocialNet> socialNets;
    
    @OneToMany(mappedBy="user")
    private List<Contact> contacts;
    
    @OneToMany(mappedBy="user")
    private List<Software> softwares;
    
    @OneToMany(mappedBy="user")
    private List<Project> projects;
    
    @OneToOne(mappedBy="user")
    private Reference reference;
}
