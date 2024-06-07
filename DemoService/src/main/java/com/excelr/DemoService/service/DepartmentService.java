package com.excelr.DemoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.DemoService.entity.Dept;
import com.excelr.DemoService.repository.DepartmentRepository;
import com.excelr.DemoService.repository.DeptDaoClass;

@Service
public class DepartmentService implements DeptServices {
	
	@Autowired
	DepartmentRepository deptrepo;

	@Autowired
	DeptDaoClass deptDao;
	
	public Dept addDepartment(Dept dept) {
		return deptrepo.save(dept);
	}

	public Dept getDepartmentById(int dno) {
		//return deptrepo.findById(dno).get();
		return deptDao.findDepartmentById(dno);
	}

}
