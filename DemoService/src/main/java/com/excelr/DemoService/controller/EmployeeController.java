package com.excelr.DemoService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.DemoService.entity.Dept;
import com.excelr.DemoService.entity.Employee;
import com.excelr.DemoService.service.DepartmentService;
import com.excelr.DemoService.service.EmployeeService;

@RestController
@RequestMapping("/excelr/v1") 
public class EmployeeController {
	
	@Autowired
	EmployeeService empservice;
	
	@Autowired
	DepartmentService deptservice;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestParam("ename") String ename,@RequestParam("sal") double sal, @RequestParam("dno") int dno)
	{
		Employee emp =new Employee();
		emp.setEname(ename);
		emp.setSal(sal);
		//Dept dept=deptservice.getDepartmentById(dno);
		emp.setDno(dno);
		
		return  empservice.addEmployee(emp);
	}

	
	@GetMapping("/getEmployeeById/{eno}")
	public Employee getEmployeeById(@PathVariable("eno") int eno)
	{
		return empservice.getEmployeeById(eno);
	}
	
	
	@GetMapping("/getEmployeesByDno/{dno}")
	public List<Employee> getEmployeesByDno(@PathVariable("dno") int dno)
	{
		return empservice.getEmployeesByDno(dno);
	}
}
