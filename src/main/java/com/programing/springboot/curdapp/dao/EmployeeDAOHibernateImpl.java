package com.programing.springboot.curdapp.dao;

import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

  private final EntityManager entityManager;

  @Autowired
  EmployeeDAOHibernateImpl(EntityManager entityManager) {
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
  public Employee findById(int theId) {
    return
        entityManager
            .unwrap(Session.class)
            .createQuery("from Employee", Employee.class)
            .getResultList()
            .stream()
            .filter(i -> i.getId() == theId)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("failed"));
  }

  @Override
  public Employee save(Employee employee) {
    entityManager
        .unwrap(Session.class)
        .saveOrUpdate(employee);
    return employee;
  }


  @Override
  public String deleteById(int employeeId) {
    String result = null;

    int numberOfDeletedRows =
        entityManager
            .unwrap(Session.class)
            .createQuery("delete from Employee where id = :employeeId")
            .setParameter("employeeId", employeeId)
            .executeUpdate();

    if (numberOfDeletedRows == 0) {
      result = "An employee with Id " + employeeId + " does not exists";
    } else {
      result = "Employee with Id " + employeeId + " deleted";
    }
    return result;
  }

}
