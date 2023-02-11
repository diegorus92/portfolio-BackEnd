/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

/**
 *
 * @author Educacion
 */
public class ProjectDTO {
    
    private String title;
    private String description;
    private String imageSrc;
    private String projectLink;

    public ProjectDTO(String title, String description, String imageSrc, String projectLink) {
        this.title = title;
        this.description = description;
        this.imageSrc = imageSrc;
        this.projectLink = projectLink;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getProjectLink() {
        return projectLink;
    }
    
    
}
