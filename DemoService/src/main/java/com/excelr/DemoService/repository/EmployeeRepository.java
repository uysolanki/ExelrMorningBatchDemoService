package com.excelr.DemoService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.excelr.DemoService.entity.Employee;
import com.excelr.DemoService.entity.Student;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	
	@Query(value = "SELECT * FROM Employee e WHERE e.dno=?1", nativeQuery = true)
	public List<Employee> findByDeptNo(int dno);

}