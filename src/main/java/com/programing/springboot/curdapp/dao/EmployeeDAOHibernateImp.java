package com.programing.springboot.curdapp.dao;

import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO{

  private EntityManager entityManager;

  @Autowired
  EmployeeDAOHibernateImp(EntityManager entityManager){
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public List<Employee> findAll() {

    Session currentSession = entityManager.unwrap(Session.class);
    return currentSession.createQuery("from Employee", Employee.class).getResultList();

  }
}
