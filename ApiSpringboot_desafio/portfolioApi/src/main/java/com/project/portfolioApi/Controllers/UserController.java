package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.UserDTO;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
   
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/users/get")
    @ResponseBody
    public List<UserDTO> getUsers(){
        List<User> users = interUserServ.getUsers();
        List<UserDTO> usersDTO = new ArrayList();
        
        for(User u : users){
            usersDTO.add(new UserDTO(u.getUserId(), u.getName(), u.getSurname(), u.getPosition(), u.getDescription()));
        }
        
        return usersDTO;
    }
    
    @GetMapping("/user/get/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        User user = interUserServ.getUserById(id);
        
        if(user == null)
            return null;
        
        UserDTO userDTO = new UserDTO(id, user.getName(), user.getSurname(),  user.getPosition(), user.getDescription());
        
        return userDTO;
    }
    
    @PostMapping("/user/create")
    public String createUser(@RequestBody User newUser){
        
        interUserServ.createUser(newUser);
        
        return "User creation success!";
    }
    
    
    @PutMapping("/user/update/{id}")
    public void updateUser( //Devuelve void porque al devolver un objeto HttpRequest, genera error en angular al hacer el put
            @PathVariable Long id,
            @RequestBody User user){
        
        User userToUpdate = interUserServ.getUserById(id);
        
        if(userToUpdate == null)
            return;
        
        userToUpdate.setUserId(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setSurname(user.getSurname());
        userToUpdate.setPosition(user.getPosition());
        userToUpdate.setDescription(user.getDescription());
        
        interUserServ.createUser(userToUpdate);
        
        
    }
    
    
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        
        interUserServ.deleteUser(id);
        
        return "User deleted";
    }
}
