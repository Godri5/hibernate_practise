package org.example.service;

import org.example.model.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> getAllProjects();

    public Project getProjectById(Long id);

    public void saveProject(Project project);

    public void deleteProject(Long id);
}
