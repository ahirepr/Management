package com.ness.org.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ness.org.entity.Department;
import com.ness.org.entity.Employee;
import com.ness.org.entity.ResourceNotFoundException;
import com.ness.org.repository.DepartmentRepo;
import com.ness.org.repository.EmployeeRepo;


@Service
public class EmployeeServiceImpl implements IEmployeeService,UserDetailsService{
	@Autowired
	private EmployeeRepo repository;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	

	@Autowired
	private EmployeeRepo employeeRepo;

	@Transactional
	public Integer saveEmployee(Employee employee,Integer departmentId) throws ResourceNotFoundException {
		employee.setPassword(
				pwdEncoder.encode(employee.getPassword())
				);
		
		
		boolean existsById = departmentRepo.existsById(departmentId);
		if(existsById) {
			 Department department = departmentRepo.findById(departmentId).get();
			employee.setDepartment(department);
			return employeeRepo.save(employee).getEmpId();
		}
		else 
			throw new ResourceNotFoundException("Department not exist");
		
		/*
		 * return departmentRepo.findById(departmentId).map(department -> {
		 * employee.setDepartment(department); employeeRepo.save(employee); return
		 * "Employee store successfully"; }).orElseThrow(() -> new
		 * ResourceNotFoundException("Department not found"));
		 */	
	}

	@Transactional(readOnly = true)
	public Employee findByEmpname(String empname) {
		Optional<Employee> employee=repository.findByUsername(empname);
		if(employee.isPresent()) 
			return employee.get();
		return null;
	}
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException 
	{
		Employee user=findByEmpname(username); 
		if(user==null) 
			throw new UsernameNotFoundException(
					new StringBuffer()
					.append("Employee name ")
					.append(username)
					.append(" not found!")
					.toString()
					);

		List<GrantedAuthority> authorities=
				user.getRoles()
				.stream()
				.map(
						role->new SimpleGrantedAuthority(role)
						)
				.collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(
				username, 
				user.getPassword(), 
				authorities);
	}

	@Override
	public ResponseEntity<?> findByEmpIdAndDepartmentId(Integer employeeId, Integer departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepo.findAll();
		
	}



	/*
	 * @Override public ResponseEntity<?> findByEmpIdAndDepartmentId(Integer
	 * employeeId, Integer departmentId) { boolean isPresent =
	 * departmentRepo.existsById(departmentId); Employee emp=null; if(isPresent) {
	 * boolean isPresentEmp = employeeRepo.existsById(employeeId); if(isPresentEmp)
	 * { emp = employeeRepo.delete(employeeId); } employeeRepo.delete(emp);
	 * 
	 * } employeeRepo.findByEmpIdAndDepartmentId(employeeId,
	 * departmentId).map(employee -> { employeeRepo.delete(employee); return
	 * ResponseEntity.ok().build(); }).orElseThrow(() -> new
	 * ResourceNotFoundException( "Employee not found with id " + employeeId +
	 * " and departmentId " + departmentId)); return null;
	 * 
	 * }
	 * 
	 */
}