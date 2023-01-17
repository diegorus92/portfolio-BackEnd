/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.portfolioApi.Services;

import com.project.portfolioApi.Models.Project;
import java.util.List;


public interface IProjectService {
    
    public void createProject(Project newProject);
    public List<Project> getProjects();
    public Project getProjectById(Long id);
    public void deleteProject(Long id);
}
