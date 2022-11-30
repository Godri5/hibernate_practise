package org.example.dao;

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
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Session currentSession = getCurrentSession();
        currentSession.saveOrUpdate(customer);
        return customer;
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer customer = getCurrentSession().get(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(Long id) {
        Session session = getCurrentSession();
        Customer customer = session.byId(Customer.class).load(id);
        session.delete(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< Customer > cq = cb.createQuery(Customer.class);
        Root< Customer > root = cq.from(Customer.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
}
