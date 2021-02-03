package com.programing.springboot.curdapp.rest;

import com.programing.springboot.curdapp.dao.EmployeeDAOHibernateImp;
import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private final EmployeeDAOHibernateImp employeeDAOHibernateImp;

  @Autowired
  public EmployeeRestController(EmployeeDAOHibernateImp employeeDAOHibernateImp) {
    this.employeeDAOHibernateImp = employeeDAOHibernateImp;
  }

  @RequestMapping("/employees")
  public List<Employee> findAllEmployee() {
    return employeeDAOHibernateImp.findAll();
  }

  @RequestMapping("/employee")
  public Employee findByEmployeeId() throws Exception {
    return employeeDAOHibernateImp.findById(2);
  }

}
