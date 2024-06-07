package com.excelr.DemoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.DemoService.entity.Dept;

@Repository
public interface DepartmentRepository extends JpaRepository<Dept, Integer> {

}