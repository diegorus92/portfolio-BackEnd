/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Controllers;

import com.project.portfolioApi.DTO.ProjectDTO;
import com.project.portfolioApi.Models.Project;
import com.project.portfolioApi.Models.User;
import com.project.portfolioApi.Services.IProjectService;
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
public class ProjectController {
    
    @Autowired
    IProjectService interProjectServ;
    
    @Autowired
    IUserService interUserServ;
    
    @GetMapping("/project/get")
    @ResponseBody
    public List<ProjectDTO> getProjects(){
        List<Project> projects = interProjectServ.getProjects();
        List<ProjectDTO> projectsDTO = new ArrayList();
        
        for(Project p : projects)
            projectsDTO.add(new ProjectDTO(p.getTitle(), p.getDescription(), p.getImageSrc(), p.getProjectLink()));
        
        return projectsDTO;
    }
    
    @GetMapping("/project/get/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id){
        Project project = interProjectServ.getProjectById(id);
        
        if(project == null)
            return null;
        
        ProjectDTO projectDTO = new ProjectDTO(project.getTitle(), project.getDescription(), project.getImageSrc(), project.getProjectLink());
        
        return projectDTO;
    }
    
    @PostMapping("/project/create/{userId}")
    public String createProject(@RequestBody Project newProject,
                                @PathVariable Long userId){
        
        User userTarget = interUserServ.getUserById(userId);
        if(userTarget == null)
            return "User not found";
        
        userTarget.getProjects().add(newProject);
        
        newProject.setUser(userTarget);
        
        interProjectServ.createProject(newProject);
        
        return "Project creation success!";
    }
    
    @PutMapping("/project/update/{id}")
    public ResponseEntity<String> updateProject(
            @PathVariable Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("imageSrc") String imageSrc,
            @RequestParam("projectLink") String projectsLink){
        
        
        Project projectToUpdate = interProjectServ.getProjectById(id);
        if(projectToUpdate == null)
            return new ResponseEntity<>("Project not found whit that ID", HttpStatus.NO_CONTENT);
        
        projectToUpdate.setTitle(title);
        projectToUpdate.setDescription(description);
        projectToUpdate.setImageSrc(imageSrc);
        projectToUpdate.setProjectLink(projectsLink);
        
        interProjectServ.createProject(projectToUpdate);
        
        return new ResponseEntity<>("Project successfuly updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable Long id){
        
        interProjectServ.deleteProject(id);
        
        return "Project deleted";
    }
}
