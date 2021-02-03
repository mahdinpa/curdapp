package com.programing.springboot.curdapp.dao;

import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {

  private final EntityManager entityManager;

  @Autowired
  EmployeeDAOHibernateImp(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {
    return entityManager
        .unwrap(Session.class)
        .createQuery("from Employee", Employee.class)
        .getResultList();
  }

  @Override
  public Employee findById(int theId) throws Exception {
    return
        entityManager
            .unwrap(Session.class)
            .createQuery("from Employee", Employee.class)
            .getResultList()
            .stream()
            .filter(i -> i.getId() == theId)
            .findFirst()
            .orElseThrow(() -> new Exception("failed"));
  }

}
