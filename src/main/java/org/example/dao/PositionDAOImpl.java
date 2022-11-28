package org.example.dao;

import org.example.model.Employee;
import org.example.model.Position;
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
public class PositionDAOImpl implements PositionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Position> getAllPositions() {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Position> cq = cb.createQuery(Position.class);
        Root<Position> root = cq.from(Position.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Position getPositionById(Long id) {
        Position position = getCurrentSession().get(Position.class, id);
        return position;
    }

    @Override
    public void savePosition(Position position) {
        getCurrentSession().saveOrUpdate(position);
    }

    @Override
    public void deletePosition(Long id) {
        Session session = getCurrentSession();
        Position position = session.byId(Position.class).load(id);
        session.delete(position);
    }
}
