package org.example.service.impl;

import org.example.dao.EntityDAO;
import org.example.model.Project;
import org.example.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements EntityService<Project> {

    @Autowired
    private EntityDAO<Project> projectDAO;

    @Override
    @Transactional
    public List<Project> getAll() {
        return projectDAO.getAll();
    }

    @Override
    @Transactional
    public Project save(Project entity) {
        return projectDAO.save(entity);
    }

    @Override
    @Transactional
    public Project getById(Long id) {
        return projectDAO.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        projectDAO.deleteById(id);
    }
}
