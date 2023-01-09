
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepo;
    
    @Override
    public void createUser(User newUser) {
        userRepo.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
    
}
