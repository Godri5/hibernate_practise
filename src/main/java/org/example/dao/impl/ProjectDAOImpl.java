package org.example.dao.impl;

import org.example.dao.EntityDAO;
import org.example.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProjectDAOImpl implements EntityDAO<Project> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Project> getAll() {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< Project > cq = cb.createQuery(Project.class);
        Root< Project > root = cq.from(Project.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Project getById(Long id) {
        return getCurrentSession().get(Project.class, id);
    }

    @Override
    public Project save(Project entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        Session session = getCurrentSession();
        Project project = session.byId(Project.class).load(id);
        session.delete(project);
    }
}
