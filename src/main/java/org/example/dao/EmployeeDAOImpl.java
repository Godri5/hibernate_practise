package org.example.dao;

import org.example.model.Employee;
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
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root< Employee > root = cq.from(Employee.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = getCurrentSession().get(Employee.class, id);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Session session = getCurrentSession();
        Employee employee = session.byId(Employee.class).load(id);
        session.delete(employee);
    }
}
