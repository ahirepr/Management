package com.ness.org.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ness.org.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	// List<Employee> findByDepartmentId(Integer departmentId);
	//Optional <Employee> findByIdAndDepartmentId(Integer employeeId, Integer departmentId);
	Optional<Employee> findByName(String empname);

	Optional<Employee> findByUsername(String empname);

	//Optional<Employee> findbyEmpIdAndDepartmentId(Integer employeeId, Integer departmentId);

	

	Employee findByEmpId(Integer employeeId);

	Optional<Employee> findByEmpIdAndDepartmentDeptId(Integer employeeId, Integer departmentId);

	
}
