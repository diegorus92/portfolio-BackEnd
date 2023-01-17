/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Project;
import com.project.portfolioApi.Repositories.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService{

    @Autowired
    ProjectRepository projectRepo;
    
    @Override
    public void createProject(Project newProject) {
        projectRepo.save(newProject);
    }

    @Override
    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }
    
}
