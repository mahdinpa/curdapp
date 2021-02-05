package com.programing.springboot.curdapp.dao;

import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

  List<Employee> findAll();

  Employee findById(int theId);

  Employee save(Employee employee);

  String deleteById(int employeeId);
}
