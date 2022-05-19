package com.ness.org.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ness.org.entity.Department;
import com.ness.org.entity.ResourceNotFoundException;
import com.ness.org.repository.DepartmentRepo;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	 @GetMapping("/department")
	    public List <Department> getDepartments() {
	        return departmentRepo.findAll();
	    }

	
	@GetMapping("/department/{id}")
    public ResponseEntity<Optional<Department>> getDepartmentById
           (@PathVariable(value = "id") Integer departmentId )
	{
      Optional<Department> findById = departmentRepo.findById(departmentId);
        return ResponseEntity.ok().body(findById);
    }

	@PostMapping("/department")
    public Department createDepartment(@RequestBody Department dept) {
        return departmentRepo.save(dept);
    }
	
	
	 @DeleteMapping("/department/{id}")
	    public ResponseEntity<String> deleteDepartment( 
	    		@PathVariable(value="id") Integer deptId){
	        
		Department findById = departmentRepo.findById(deptId).get();
		 if(findById==null)
			 return ResponseEntity.ok().body("Department not exist with this "+findById);
		 departmentRepo.delete(findById);
	       String msg="Department deleted successfully ......";
	        return ResponseEntity.ok().body(msg);
	 }
	 
		@PutMapping("/department/{id}")
		public ResponseEntity<Department> updateUser(@PathVariable(value = "id") Integer departmentId,
				@RequestBody Department department) throws ResourceNotFoundException {
			Department dept = departmentRepo.findById(departmentId).get();

			dept.setDeptName(department.getDeptName());
			dept.setCityLocation(department.getCityLocation());

			Department updatedUser = departmentRepo.save(dept);
			return ResponseEntity.ok(updatedUser);
		}
	 
	        
	
}
