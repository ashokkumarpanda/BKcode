package com.cozentus.service;

import java.util.List;

import com.cozentus.model.Employees;

public interface EmployeeService {
	Employees createEmp(Employees emp);
    List<Employees> getAllEmployees();
    Employees getEmployeesById(long employeeId);
    Employees updateEmployee(Employees employee, long id);
    void deleteEmployee(long id);
    
	
	
}
