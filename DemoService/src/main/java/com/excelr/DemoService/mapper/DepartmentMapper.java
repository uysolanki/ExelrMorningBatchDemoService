package com.excelr.DemoService.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.excelr.DemoService.entity.Dept;

public class DepartmentMapper implements RowMapper<Dept>{

	@Override
	public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dept dept=new Dept();
		dept.setDno(rs.getInt(1));
		dept.setCity(rs.getString(2));
		dept.setDname(rs.getString(3));
		return dept;
	}

}
