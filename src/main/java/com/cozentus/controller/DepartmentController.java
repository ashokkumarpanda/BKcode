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

import com.cozentus.dto.DepartmentDto;
import com.cozentus.model.Department;
import com.cozentus.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
  private DepartmentService departmentService;



@PostMapping()
public ResponseEntity<DepartmentDto> createPost(@RequestBody DepartmentDto employeeDto) {

	// convert DTO to entity
	Department depRequest = modelMapper.map(employeeDto, Department.class);

	Department dep =departmentService.createDep(depRequest);

	// convert entity to DTO
	DepartmentDto empResponse = modelMapper.map(dep, DepartmentDto.class);

	return new ResponseEntity<>(empResponse, HttpStatus.CREATED);
}
@GetMapping()
	public List<DepartmentDto> getAllDepartment(){
	 return departmentService.getAllDepartment().stream().map(dep -> modelMapper.map(dep, DepartmentDto.class))
				.collect(Collectors.toList());
}
@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Integer id) {
	Department dep = departmentService.getDepartmentById(id);

		
	 DepartmentDto postResponse = modelMapper.map(dep, DepartmentDto.class);

		return ResponseEntity.ok().body(postResponse);
	}
@PutMapping("{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id
												  ,@RequestBody Department department){
		return new ResponseEntity<>(departmentService.updateDepartment(department, id), HttpStatus.OK);
	}
@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id){
		
	departmentService.deleteDepartment(id);
		
		return new ResponseEntity<>("Department id deleted successfully!.", HttpStatus.OK);
	}
}
