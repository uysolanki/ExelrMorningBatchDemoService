//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
package com.excelr.DemoService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.excelr.DemoService.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findByPerGreaterThan(double x);

	@Query(value = "SELECT * FROM Student u WHERE u.sname like 'A%'", nativeQuery = true)
	public List<Student> getStudentsWhoseNameStartWithCharA();
	
	@Query(value = "SELECT * FROM Student u WHERE u.sname like ?1%", nativeQuery = true)
	public List<Student> getStudentsWhoseNameStartWithUDChar(char x);
}
