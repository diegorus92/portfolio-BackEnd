/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.SocialNetIcon;
import java.util.List;


public interface ISocialNetIconService {
    
    public void createSocialNetIcon(SocialNetIcon newSocialIcon);
    public List<SocialNetIcon> getSocialNetIcons();
    public SocialNetIcon getSocialNetIconById(Long id);
    public void deleteSocialNetIcon(Long id);
}
