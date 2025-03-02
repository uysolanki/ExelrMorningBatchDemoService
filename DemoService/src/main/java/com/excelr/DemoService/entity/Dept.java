package com.excelr.DemoService.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dept {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dno;
	private String dname;
	private String city;
	
	@OneToMany(mappedBy = "dno",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Employee> employees;
	
}
