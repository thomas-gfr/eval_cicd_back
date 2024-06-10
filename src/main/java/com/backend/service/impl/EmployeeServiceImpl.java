package com.backend.service.impl;

import com.backend.dto.EmployeeDTO;
import com.backend.entity.Employee;
import com.backend.exception.EmployeeNotFound;
import com.backend.repository.EmployeeRepository;
import com.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee addEmployee(EmployeeDTO dto) {
		Employee employee1 = Employee.builder().firstName(dto.getFirstName()).lastName(dto.getLastName())
				.contactNumber(dto.getContactNumber()).dob(dto.getDob()).email(dto.getEmail()).password(dto.getPassword()).build();
		return repository.save(employee1);
	}

	@Override
	public Employee updateEmployee(int id, EmployeeDTO dto) {
		Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee Not Found"));
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setContactNumber(dto.getContactNumber());
		employee.setDob(dto.getDob());
		employee.setEmail(dto.getEmail());
		employee.setPassword(dto.getPassword());
		return repository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployee(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public void deleteEmployee(int id) {
		Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee Not Found"));
		repository.delete(employee);
	}

	@Override
	public Optional<Employee> signin(String userName, String password) {
		return repository.findByEmailAndPassword(userName, password);
	}
}