package com.excelr.DemoService.service;

import com.excelr.DemoService.entity.Dept;

public interface DeptServices {
	public Dept addDepartment(Dept dept);
	

	public Dept getDepartmentById(int dno);

}
