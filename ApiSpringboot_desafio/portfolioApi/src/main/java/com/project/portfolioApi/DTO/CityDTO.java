/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;

import java.io.Serializable;


public class CityDTO implements Serializable{
    
    private String name;

    public CityDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
}
