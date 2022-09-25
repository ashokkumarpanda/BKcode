package com.cozentus.dto;

import com.cozentus.model.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	private Department department;
}
