/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.DTO;


public class ReferenceDTO {
    
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String position;

    public ReferenceDTO(String name, String surname, String phone, String email, String position) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }
    
    
}
