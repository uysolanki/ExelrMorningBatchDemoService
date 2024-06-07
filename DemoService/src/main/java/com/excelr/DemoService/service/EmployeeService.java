package com.excelr.DemoService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.DemoService.entity.Dept;
import com.excelr.DemoService.entity.Employee;
import com.excelr.DemoService.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepo;

	public Employee addEmployee(Employee emp) {
		return emprepo.save(emp);
	}

	public Employee getEmployeeById(int eno) {
		return emprepo.findById(eno).get();
	}

	public List<Employee> getEmployeesByDno(int dno) {
		return emprepo.findByDeptNo(dno);
	}

	
}
