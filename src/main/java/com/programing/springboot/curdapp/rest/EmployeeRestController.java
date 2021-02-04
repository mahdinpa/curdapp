package com.programing.springboot.curdapp.rest;

import com.programing.springboot.curdapp.entity.Employee;
import com.programing.springboot.curdapp.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private final EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @RequestMapping("/employees")
  public List<Employee> findAllEmployee() {
    return employeeService.findAll();
  }

  @RequestMapping("/employee")
  public Employee findByEmployeeId() throws Exception {
    return employeeService.findById(2);
  }

}
