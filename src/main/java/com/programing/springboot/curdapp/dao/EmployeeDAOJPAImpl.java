package com.programing.springboot.curdapp.dao;

import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOJPAImpl implements
    EmployeeDAO {

  private final EntityManager entityManager;

  @Autowired
  public EmployeeDAOJPAImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {

    return entityManager.createQuery("from Employee", Employee.class).getResultList();

  }

  @Override
  public Employee findById(int theId) {
    return entityManager.find(Employee.class, theId);
  }

  @Override
  public Employee save(Employee employee) {
    return entityManager.merge(employee);
  }

  @Override
  public String deleteById(int theId) {
    String result = null;
    int numberOfDeletedRows =
        entityManager.createQuery("delete from Employee where id = :employeeId")
            .setParameter("employeeId", theId)
            .executeUpdate();

    if (numberOfDeletedRows == 0) {
      result = "An employee with Id " + theId + " does not exists";
    } else {
      result = "Employee with Id " + theId + " deleted";
    }
    return result;

  }
}
