package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


@SpringBootTest
@WebMvcTest
class DemoApplicationTests {
	
	  String expected="Welcome to Swagger Docs API test";
	  
	  @MockBean EmployeeRepo erepo;
	  
	  @Autowired private MockMvc mockMvc;
	  
	  @Autowired EmployeeController empcontroller;
	  
	  
	  
	  
	  @Test void contextLoads() { }
	  
	  @Test public void shouldReturnString_getWelcomeMessage() throws Exception {
	  String actual = empcontroller.getWelcomeMessage(); // assert that actual and
	  Assertions.assertEquals(expected, actual); }
	  
	  @Test
	  
	  @Order(1) public void addEmployee () { Employee p = new Employee();
	  p.setEmpId(1); p.setName("Ghost"); p.setUsername("ghost");
	  p.setPassword("Passwaord@123#1998"); p.setSalary(13500); erepo.save(p);
	  Assertions.assertNotNull(erepo.findById(1).get()); }
	  
	  
	  
	/*
	 * @Test public void
	 * givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws
	 * Exception{ // given - precondition or setup List<Employee> listOfEmployees =
	 * new ArrayList<>();
	 * 
	 * listOfEmployees.add(Employee.builder().build());
	 * listOfEmployees.add(Employee.builder().build());
	 * 
	 * listOfEmployees.add(new Employee(7, "Raja", 12000, "raja", "raja@123"));
	 * listOfEmployees.add(new Employee(7, "Rama", 12000, "rama", "rama@123"));
	 * listOfEmployees.add(new Employee(7, "Rani", 12000, "rani", "rani@123"));
	 * given(erepo.findAll()).willReturn(listOfEmployees);
	 * 
	 * // when - action or the behaviour that we are going test ResultActions
	 * response = mockMvc.perform(get("/api/employees"));
	 * 
	 * // then - verify the output response.andExpect(status().isOk())
	 * .andDo(print()) .andExpect(jsonPath("$.size()", is(listOfEmployees.size())));
	 * 
	 * }
	 */
	  
	 }
