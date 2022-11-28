package org.example.dao;

import org.example.model.Project;

import java.util.List;

public interface ProjectDAO {

    public List<Project> getAllProjects();

    public Project getProjectById(Long id);

    public void saveProject(Project project);

    public void deleteProject(Long id);
}
