package org.example.dao.impl;

import org.example.dao.EntityDAO;
import org.example.model.Position;
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
public class PositionDAOImpl implements EntityDAO<Position> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Position> getAll() {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Position> cq = cb.createQuery(Position.class);
        Root<Position> root = cq.from(Position.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Position getById(Long id) {
        return getCurrentSession().get(Position.class, id);
    }

    @Override
    public Position save(Position entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        Session session = getCurrentSession();
        Position position = session.byId(Position.class).load(id);
        session.delete(position);
    }
}
