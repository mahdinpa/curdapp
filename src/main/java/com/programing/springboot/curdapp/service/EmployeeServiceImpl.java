package com.programing.springboot.curdapp.service;

import com.programing.springboot.curdapp.dao.EmployeeDAO;
import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements
    EmployeeService {

  EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  @Transactional
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  @Transactional
  public Employee findById(int theId) throws Exception {
    return employeeDAO.findById(theId);
  }

  @Override
  @Transactional
  public void save(Employee employee) {
    employeeDAO.save(employee);
  }

  @Override
  @Transactional
  public void deleteById(int theId) {
    employeeDAO.deleteById(theId);
  }
}
