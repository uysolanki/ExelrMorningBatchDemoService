package com.excelr.DemoService.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.DemoService.entity.Dept;
import com.excelr.DemoService.service.DepartmentService;
import com.excelr.DemoService.service.EmployeeService;

@RestController
@RequestMapping("/excelr/v1") 
public class DepartmentController {
	
	@Autowired
	DepartmentService deptservice;
	
	@Autowired
	EmployeeService empservice;
	
	private static final Logger logger=Logger.getLogger(DepartmentController.class);
	
	@PostMapping("/addDepartment")
	public Dept addDepartment(@RequestParam("dname") String dname,@RequestParam("city") String city)
	{
		logger.info("Add Department API Called");//cross cutting task  Aspect Oriented Programming AOP
		Dept dept =new Dept();
		dept.setDname(dname);
		dept.setCity(city);
		logger.info("Add Department API Completed");
		return  deptservice.addDepartment(dept);
	}
	
	@GetMapping("/getDepartmentById/{deptno}")
	public Dept getStudentById(@PathVariable("deptno") int dno)
	{
		return deptservice.getDepartmentById(dno);
	}
	

}
