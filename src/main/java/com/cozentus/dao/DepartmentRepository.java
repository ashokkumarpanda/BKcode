package com.cozentus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cozentus.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
