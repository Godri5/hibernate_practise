package org.example.dao.impl;

import org.example.dao.EntityDAO;
import org.example.model.Customer;
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
public class CustomerDAOImpl implements EntityDAO<Customer> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Customer> getAll() {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< Customer > cq = cb.createQuery(Customer.class);
        Root< Customer > root = cq.from(Customer.class);
        Query query = session.createQuery(cq.select(root));
        return query.getResultList();
    }

    @Override
    public Customer getById(Long id) {
        return getCurrentSession().get(Customer.class, id);
    }

    @Override
    public Customer save(Customer customer) {
        Session currentSession = getCurrentSession();
        currentSession.saveOrUpdate(customer);
        return customer;
    }

    @Override
    public void deleteById(Long id) {
        Session session = getCurrentSession();
        Customer customer = session.byId(Customer.class).load(id);
        session.delete(customer);
    }
}
