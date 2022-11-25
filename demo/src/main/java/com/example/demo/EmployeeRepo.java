package com.example.demo;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository("employeeRepo")
public interface EmployeeRepo extends CrudRepository<Employee,Integer>{

	Employee findByEmpId(Integer employeeId);
	

	
}
