package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IUserService;
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
public class UserController {
   
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/users/get")
    @ResponseBody
    public List<User> getUsers(){
        List users = interUserServ.getUsers();
        
        return users;
    }
    
    @GetMapping("/user/get/{id}")
    public User getUserById(@PathVariable Long id){
        User user = interUserServ.getUserById(id);
        
        return user;
    }
    
    @PostMapping("/user/create")
    public String createUser(@RequestBody User newUser){
        
        interUserServ.createUser(newUser);
        
        return "User creation success!";
    }
    
    @PutMapping("/user/update/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("nickname") String nickname,
            @RequestParam("password") String password,
            @RequestParam("position") String position,
            @RequestParam("description") String description,
            @RequestParam("bannerSrc") String banner,
            @RequestParam("profileImageSrc") String profileImage){
        
        User userToUpdate = interUserServ.getUserById(id);
        
        if(userToUpdate == null)
            return new ResponseEntity<>("User not found whit that ID", HttpStatus.NO_CONTENT);
        
        userToUpdate.setName(name);
        userToUpdate.setSurname(surname);
        userToUpdate.setNickname(nickname);
        userToUpdate.setPassword(password);
        userToUpdate.setPosition(position);
        userToUpdate.setDescription(description);
        userToUpdate.setProfileImageSrc(profileImage);
        userToUpdate.setBannerSrc(banner);
        
        interUserServ.createUser(userToUpdate);
        
        return new ResponseEntity<>("User successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        
        interUserServ.deleteUser(id);
        
        return "User deleted";
    }
}
