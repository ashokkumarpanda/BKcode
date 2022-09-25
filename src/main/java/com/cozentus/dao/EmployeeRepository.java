package com.cozentus.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cozentus.model.Employees;
@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long>{

	Optional<Employees> findById(Long id);

}
