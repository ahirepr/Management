package com.ness.org.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ness.org.entity.Employee;
import com.ness.org.entity.ResourceNotFoundException;
@Service
public interface IEmployeeService {

	public Integer saveEmployee(Employee employee, Integer departmentId) throws ResourceNotFoundException;
	public Employee findByEmpname(String employeename);
	public ResponseEntity<?> findByEmpIdAndDepartmentId(Integer employeeId, Integer departmentId);
	public List<Employee> findAll();


}
