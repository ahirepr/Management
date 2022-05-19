package com.ness.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ness.org.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
