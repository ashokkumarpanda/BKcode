package com.cozentus.dto;

import java.util.List;

import com.cozentus.model.Employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
	private long id;
	private String departmentName;
	private List<Employees> listemployees;
}
