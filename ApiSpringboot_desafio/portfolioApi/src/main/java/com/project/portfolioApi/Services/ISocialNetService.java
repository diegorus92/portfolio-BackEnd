/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.SocialNet;
import java.util.List;


public interface ISocialNetService {
    
    public void createSocialNet(SocialNet newSocialNet);
    public List<SocialNet> getSocialNets();
    public SocialNet getSocialNetById(Long id);
    public void deleteSocialNet(Long id);
}
