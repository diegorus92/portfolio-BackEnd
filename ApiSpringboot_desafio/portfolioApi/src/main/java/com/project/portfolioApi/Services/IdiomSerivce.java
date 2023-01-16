/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Idiom;
import com.project.portfolioApi.Repositories.IdiomRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomSerivce implements IIdiomService{

    @Autowired
    IdiomRepository idiomRepo;
    
    @Override
    public void createIdiom(Idiom newIdiom) {
        idiomRepo.save(newIdiom);
    }

    @Override
    public List<Idiom> getIdioms() {
        return idiomRepo.findAll();
    }

    @Override
    public Idiom getIdiomById(Long id) {
        return idiomRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteIdiom(Long id) {
        idiomRepo.deleteById(id);
    }
    
}
