/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.SocialNetIcon;
import com.project.portfolioApi.Repositories.SocialNetIconRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialNetIconService implements ISocialNetIconService{

    @Autowired
    SocialNetIconRepository socialNetIconRepo;
    
    @Override
    public void createSocialNetIcon(SocialNetIcon newSocialIcon) {
        socialNetIconRepo.save(newSocialIcon);
    }

    @Override
    public List<SocialNetIcon> getSocialNetIcons() {
        return socialNetIconRepo.findAll();
    }

    @Override
    public SocialNetIcon getSocialNetIconById(Long id) {
        return socialNetIconRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSocialNetIcon(Long id) {
        socialNetIconRepo.deleteById(id);
    }
    
}
