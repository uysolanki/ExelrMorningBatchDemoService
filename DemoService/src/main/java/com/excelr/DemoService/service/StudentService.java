package com.excelr.DemoService.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.DemoService.entity.Product;
import com.excelr.DemoService.entity.Student;
import com.excelr.DemoService.repository.StudentRepository;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentrepo;

	public Student addStudent(Student student) {
		return studentrepo.save(student);
		
	}

	public List<Student> getAllStudents() {
	
		return studentrepo.findAll();
	}

	public Student getStudentById(int rno) {
		return studentrepo.findById(rno).get();
	}

	public List<Student> getStudentsAbove80Percent(double i) {
		
		return studentrepo.findByPerGreaterThan(i);
	}

	public List<Student> getStudentsWhoseNameStartWithA() {
		return studentrepo.getStudentsWhoseNameStartWithCharA();
	}

	public void deleteStudentById(int rno) {
		studentrepo.deleteById(rno);
	}

	public Student updateStudentById(int rno, Student studentfromfe) {
		Student studentfromdb=studentrepo.findById(rno).get();
		studentfromdb.setSname(studentfromfe.getSname());
		studentfromdb.setPer(studentfromfe.getPer());
		return studentrepo.save(studentfromdb);
	}

	public List<Student> getStudentsWhoseNameStartWithUDChar(char x) {
		return studentrepo.getStudentsWhoseNameStartWithUDChar(x);
	}

	public List<Student> addMultipleStudents(List<Student> students) {
		return studentrepo.saveAll(students);
		
	}

	public List<Student> addStudentsFromJSONFIle() {
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/student.json");
        List<Student> students=null;
        try {
			students = mapper.readValue(inputStream,typeReference);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return studentrepo.saveAll(students);
	}


}
