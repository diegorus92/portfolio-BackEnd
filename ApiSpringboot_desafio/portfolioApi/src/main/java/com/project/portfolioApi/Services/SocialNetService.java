/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.SocialNet;
import com.project.portfolioApi.Repositories.SocialNetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialNetService implements ISocialNetService{

    @Autowired
    SocialNetRepository socialNetRepo;
    
    @Override
    public void createSocialNet(SocialNet newSocialNet) {
        socialNetRepo.save(newSocialNet);
    }

    @Override
    public List<SocialNet> getSocialNets() {
        return socialNetRepo.findAll();
    }

    @Override
    public SocialNet getSocialNetById(Long id) {
        return socialNetRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSocialNet(Long id) {
        socialNetRepo.deleteById(id);
    }
    
}
