package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController(value="/v1")
@EnableJpaRepositories
public class EmployeeController {

	@Autowired
	@Qualifier("employeeRepo")
	private EmployeeRepo employeeRepo;

	/*
	 * @Autowired
	 * 
	 * @Qualifier("employeeService") private IEmployeeService service;
	 */

	@GetMapping("/")
	public List<Employee> getEmployee() {

		return (List<Employee>) employeeRepo.findAll();

	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "employeeId") Integer employeeId)
			throws ResourceNotFoundException {

		employeeRepo.deleteById(employeeId);
		return new ResponseEntity<>("Employee removed successfully", HttpStatus.OK);
	}

	@PutMapping("employee/{employeeId}")
	public Employee updateEmployee(@PathVariable(value = "employeeId") Integer employeeId,
			@RequestBody Employee employeeRequest) throws ResourceNotFoundException {

		boolean existsById = employeeRepo.existsById(employeeId);
		Employee emp = null;
		if (existsById) {
			emp = employeeRepo.findByEmpId(employeeId);
			emp.setName(employeeRequest.getName());
			return employeeRepo.save(emp);
		} else
			throw new ResourceNotFoundException("employee id not found");
	}
	
	@PostMapping("save}")
	public Employee addEmployee(
			@RequestBody Employee employeeRequest){

			return employeeRepo.save(employeeRequest);
	}
	@GetMapping("/view")
	public ResponseEntity<?> getWelcomePage() {

		return new ResponseEntity<>("Welcome to Swagger Docs API test", HttpStatus.OK);
		

	}
	@GetMapping("/view/v1")
	public String getWelcomeMessage() {

		return"Welcome to Swagger Docs API test";
		

	}
		

}
