/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Interest;
import com.project.portfolioApi.Repositories.InterestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestService implements IInterestService{

    @Autowired
    InterestRepository interestRepo;
    
    @Override
    public void createInterest(Interest newInterest) {
        interestRepo.save(newInterest);
    }

    @Override
    public List<Interest> getInterests() {
        return interestRepo.findAll();
    }

    @Override
    public Interest getInterestById(Long id) {
        return interestRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteInterest(Long id) {
        interestRepo.deleteById(id);
    }
    
}
