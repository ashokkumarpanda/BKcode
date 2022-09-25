package com.cozentus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cozentus.dao.DepartmentRepository;
import com.cozentus.exception.ResourceNotFoundException;
import com.cozentus.model.Department;

@Service
public class DepartMentImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	

	@Override
	public Department createDep(Department departMent) {
		
		return departmentRepository.save(departMent);
	}


	@Override
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}


	@Override
	public Department getDepartmentById(long id) {
		return departmentRepository.findById(id).orElseThrow(
		     	() -> new ResourceNotFoundException("Departmant", "Id", id));
	}


	@Override
	public Department updateDepartment(Department department, long id) {
		Department existingDepartment = departmentRepository.findById(id).orElseThrow(
		     	() -> new ResourceNotFoundException("Department", "Id", id)); 
	
	existingDepartment.setDepartmentName(department.getDepartmentName());
	
	// save existing employee to DB
	departmentRepository.save(existingDepartment);
	return existingDepartment;
}


	@Override
	public void deleteDepartment(long id) {
		departmentRepository.findById(id).orElseThrow(() -> 
                              new ResourceNotFoundException("Department", "Id", id));
		departmentRepository.deleteById(id);

}
	}


