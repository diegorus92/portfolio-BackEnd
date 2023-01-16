/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Idiom;
import java.util.List;

/**
 *
 * @author Educacion
 */
public interface IIdiomService {
    
    public void createIdiom(Idiom newIdiom);
    public List<Idiom> getIdioms();
    public Idiom getIdiomById(Long id);
    public void deleteIdiom(Long id);
}
