/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Interest;
import java.util.List;


public interface IInterestService {
    
    public void createInterest(Interest newInterest);
    public List<Interest> getInterests();
    public Interest getInterestById(Long id);
    public void deleteInterest(Long id);
}
