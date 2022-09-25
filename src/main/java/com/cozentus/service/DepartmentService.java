package com.cozentus.service;

import java.util.List;

import com.cozentus.model.Department;


public interface DepartmentService {
   Department createDep(Department departMent);	
   List<Department> getAllDepartment();
   Department getDepartmentById(long departmentid);
   Department updateDepartment(Department department, long id);
   void deleteDepartment(long id);
}
