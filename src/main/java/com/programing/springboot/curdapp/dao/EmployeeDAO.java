package com.programing.springboot.curdapp.dao;

import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

  public List<Employee> findAll();

}
