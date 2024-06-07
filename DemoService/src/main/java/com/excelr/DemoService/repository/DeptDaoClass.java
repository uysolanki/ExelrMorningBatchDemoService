package com.excelr.DemoService.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.excelr.DemoService.entity.Dept;
import com.excelr.DemoService.entity.Employee;
import com.excelr.DemoService.mapper.DepartmentMapper;
import com.excelr.DemoService.service.EmployeeService;

@Repository
public class DeptDaoClass {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	EmployeeService empservice;
	public Dept findDepartmentById(int dno) {
		String query="select * from dept where dno=?";
		Dept dept=this.jdbcTemplate.queryForObject(query,new DepartmentMapper(), dno);
		List<Employee> emplist=empservice.getEmployeesByDno(dno);
		dept.setEmployees(emplist);
		return dept;
	}

}
