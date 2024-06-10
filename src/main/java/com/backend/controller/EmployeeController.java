package com.backend.controller;

import com.backend.dto.EmployeeDTO;
import com.backend.entity.Employee;
import com.backend.exception.EmployeeNotFound;
import com.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/")
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO dto) {
		return new ResponseEntity<>(service.addEmployee(dto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO dto) {
		return ResponseEntity.ok(service.updateEmployee(id, dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		Optional<Employee> employee = service.getEmployee(id);
		return employee.map(ResponseEntity::ok).orElseThrow(() -> new EmployeeNotFound("Employee Not Found"));
	}

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(service.getAllEmployees());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{userName}/{password}")
	public ResponseEntity<String> signIn(@PathVariable String userName, @PathVariable String password) {
		Optional<Employee> employee = service.signin(userName, password);
		if (employee.isPresent()) {
			return ResponseEntity.ok("SignIn Successfully");
		} else {
			return ResponseEntity.badRequest().body("Invalid Credential !!!");
		}
	}
}