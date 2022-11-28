package org.example.service;

import org.example.dao.ProjectDAO;
import org.example.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    @Transactional
    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    @Override
    @Transactional
    public Project getProjectById(Long id) {
        return projectDAO.getProjectById(id);
    }

    @Override
    @Transactional
    public void saveProject(Project project) {
        projectDAO.saveProject(project);
    }

    @Override
    @Transactional
    public void deleteProject(Long id) {
        projectDAO.deleteProject(id);
    }
}
