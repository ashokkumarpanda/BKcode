package com.cozentus.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cozentus.dto.EmployeeDto;
import com.cozentus.model.Employees;
import com.cozentus.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createPost(@RequestBody EmployeeDto employeeDto) {

		
		Employees empRequest = modelMapper.map(employeeDto, Employees.class);

		Employees emp = employeeService.createEmp(empRequest);

		
		EmployeeDto empResponse = modelMapper.map(emp, EmployeeDto.class);

		return new ResponseEntity<>(empResponse, HttpStatus.CREATED);
	}
     
     @GetMapping()
 	public List<EmployeeDto> getAllEmployees(){
    	 return employeeService.getAllEmployees().stream().map(emp -> modelMapper.map(emp, EmployeeDto.class))
 				.collect(Collectors.toList());
     }
     @GetMapping("/{id}")
 	public ResponseEntity<EmployeeDto> getEmployeesById(@PathVariable("id") Long id) {
    	 Employees emp = employeeService.getEmployeesById(id);

 		
 		EmployeeDto postResponse = modelMapper.map(emp, EmployeeDto.class);

 		return ResponseEntity.ok().body(postResponse);
 	}
     @PutMapping("{id}")
 	public ResponseEntity<Employees> updateEmployee(@PathVariable("id") long id
 												  ,@RequestBody Employees employee){
 		return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
 	}
     @DeleteMapping("{id}")
 	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
 		
 		employeeService.deleteEmployee(id);
 		
 		return new ResponseEntity<>("Employee deleted successfully!.", HttpStatus.OK);
 	}
}
