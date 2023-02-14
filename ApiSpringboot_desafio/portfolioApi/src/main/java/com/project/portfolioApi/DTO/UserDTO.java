/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

import java.io.Serializable;


public class UserDTO implements Serializable{
    
    private Long userId;
    private String name;
    private String surname;
    private String position;
    private String description;

    public UserDTO(Long userId, String name, String surname, String position, String description) {
        
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.description = description;
    }
    
    public UserDTO(String name, String surname, String position, String description) {
       
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.description = description;
    }

    public Long getUserId(){
        return userId;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
