package com.cozentus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cozentus.dao.EmployeeRepository;
import com.cozentus.exception.ResourceNotFoundException;
import com.cozentus.model.Employees;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public List<Employees> getAllEmployees() {
		return employeeRepository.findAll();
	}



	@Override
	public Employees createEmp(Employees emp) {
		return employeeRepository.save(emp);
	}


	@Override
	public Employees getEmployeesById(long id) {
		return employeeRepository.findById(id).orElseThrow(() -> 
		               new ResourceNotFoundException("Employees", "Id", id));
		}


	@Override
	public Employees updateEmployee(Employees employee, long id) {
		Employees existingEmployee = employeeRepository.findById(id).orElseThrow(
			     	() -> new ResourceNotFoundException("Employee", "Id", id)); 
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setSalary(employee.getSalary());
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> 
		               new ResourceNotFoundException("Employees", "Id", id));
                               employeeRepository.deleteById(id);
		
	}


		
	}


