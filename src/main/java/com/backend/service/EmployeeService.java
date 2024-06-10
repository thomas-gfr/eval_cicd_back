package com.backend.service;

import com.backend.dto.EmployeeDTO;
import com.backend.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

	Employee addEmployee(EmployeeDTO dto);

	Employee updateEmployee(int id, EmployeeDTO dto);

	Optional<Employee> getEmployee(int id);

	List<Employee> getAllEmployees();

	void deleteEmployee(int id);

	Optional<Employee> signin(String userName, String password);
}