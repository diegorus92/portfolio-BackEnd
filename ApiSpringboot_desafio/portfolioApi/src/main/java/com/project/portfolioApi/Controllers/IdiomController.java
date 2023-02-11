/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.IdiomDTO;
import com.project.portfolioApi.Models.Idiom;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IIdiomService;
import com.project.portfolioApi.Services.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdiomController {
    
    @Autowired
    IIdiomService interIdiomServ;
    
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/idiom/get")
    @ResponseBody
    public List<IdiomDTO> getIdioms(){
        List<Idiom> idioms = interIdiomServ.getIdioms();
        List<IdiomDTO> idiomsDTO = new ArrayList();
        
        for(Idiom i : idioms)
            idiomsDTO.add(new IdiomDTO(i.getName(), i.getValue()));
        
        return idiomsDTO;
    }
    
    @GetMapping("/idiom/get/{id}")
    public IdiomDTO getIdiomtById(@PathVariable Long id){
        Idiom idiom = interIdiomServ.getIdiomById(id);
        
        if(idiom == null)
            return null;
        
        IdiomDTO idiomDTO = new IdiomDTO(idiom.getName(), idiom.getValue());
        
        return idiomDTO;
    }
    
    @PostMapping("/idiom/create/{userId}")
    public String createInterest(@RequestBody Idiom newIdiom, @PathVariable Long userId){
        
        User userTarget = interUserServ.getUserById(userId);
        
        if(userTarget == null)
            return "User not found";
        
        userTarget.getIdioms().add(newIdiom);
        newIdiom.setUser(userTarget);
        
        interIdiomServ.createIdiom(newIdiom);
        
        return "Idiom creation success!";
    }
    
    @PutMapping("/idiom/update/{id}")
    public ResponseEntity<String> updateIdiom(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("value") String value){
        
        Idiom idiomToUpdate = interIdiomServ.getIdiomById(id);
        
        if(idiomToUpdate == null)
            return new ResponseEntity<>("Idiom not found whit that ID", HttpStatus.NO_CONTENT);
        
        idiomToUpdate.setName(name);
        idiomToUpdate.setValue(value);
        
        
        interIdiomServ.createIdiom(idiomToUpdate);
        
        return new ResponseEntity<>("Idiom successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/idiom/delete/{id}")
    public String deleteIdiom(@PathVariable Long id){
        
        interIdiomServ.deleteIdiom(id);
        
        return "Idiom deleted";
    }
}
