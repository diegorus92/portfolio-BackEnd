/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;


public class SocialNetDTO {
    
    private String iconName;
    private String link;

    public SocialNetDTO(String iconName, String link) {
        this.iconName = iconName;
        this.link = link;
    }

    public String getIconName() {
        return iconName;
    }

    public String getLink() {
        return link;
    }
    
    
}
