/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

import java.io.Serializable;


public class UserDTO implements Serializable{
    
    private String name;
    private String surname;
    private String nickname;
    private String position;
    private String description;
    private String bannerSrc;
    private String profileImageSrc;

    public UserDTO(String name, String surname, String nickname, String position, String description, String bannerSrc, String profileImageSrc) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.position = position;
        this.description = description;
        this.bannerSrc = bannerSrc;
        this.profileImageSrc = profileImageSrc;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public String getBannerSrc() {
        return bannerSrc;
    }

    public String getProfileImageSrc() {
        return profileImageSrc;
    }
    
    
}
