/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.User;
import java.util.List;

/**
 *
 * @author Educacion
 */
public interface IUserService {
    
    public void createUser(User newUser);
    public List<User> getUsers();
    public User getUserById(Long id);
    public void deleteUser(Long id);
}
