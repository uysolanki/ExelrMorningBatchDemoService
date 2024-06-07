/*200 - Success , OK
400 - RequestBody is incorrect

403 - UnAuthorised
404 - Endpoint does not exist
405 - Http Method is incorrect

500 - Programmer Logic*/

package com.excelr.DemoService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.DemoService.entity.AmazonProducts;
import com.excelr.DemoService.entity.Product;
import com.excelr.DemoService.entity.Student;
import com.excelr.DemoService.entity.Teacher;
import com.excelr.DemoService.service.AmazonProductService;
import com.excelr.DemoService.service.ProductService;
import com.excelr.DemoService.service.StudentService;

@RestController
@RequestMapping("/excelr/v1")  //localhost:8080/excelr/v1/getStudent
public class DemoController {

	@Value("${info.developer-name}")
	String developerName;
	
	@Value("${info.developer-email}")
	String developerEmail;
	
	@Autowired
	StudentService studentservice;
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	AmazonProductService amazonproductservice;
	
	@PostMapping("/home")
	public String greet()
	{
		return "Welcome, "+developerName+" to My Demo Springboot Application, contact : "+developerEmail;
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestParam("studentname") String sname,@RequestParam("studentper") double per)
	{
		Student student =new Student();
		student.setSname(sname);
		student.setPer(per);
		return  studentservice.addStudent(student);
		//"Student Record Addedd successfully";
	}
	
	@PostMapping("/addStudentByPathVariable/{studentname}/{studentper}")
	public Student addStudentByPathVariable(@PathVariable("studentname") String sname,@PathVariable("studentper") double per)
	{
		Student student =new Student();
		student.setSname(sname);
		student.setPer(per);
		return  studentservice.addStudent(student);
		//"Student Record Addedd successfully";
	}
	
	@PostMapping("/addStudentByRequestBody")
	public Student addStudentByRequestBody(@RequestBody Student student)
	{
		return  studentservice.addStudent(student);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents()
	{
		return  studentservice.getAllStudents();
	}
	
	@GetMapping("/getStudentById/{studrno}")
	public Student getStudentById(@PathVariable("studrno") int rno)
	{
		return studentservice.getStudentById(rno);
	}
	
	@GetMapping("/getStudentsAbove80Percent")
	public List<Student> getStudentsAbove80Percent()
	{
		return studentservice.getStudentsAbove80Percent(80.0);
	}
	
	@GetMapping("/getStudentsWhoseNameStartWithA")
	public List<Student> getStudentsWhoseNameStartWithA()
	{
		return studentservice.getStudentsWhoseNameStartWithA();
	}
	
	@GetMapping("/getStudentsWhoseNameStartWithUDChar")
	public List<Student> getStudentsWhoseNameStartWithUDChar(@RequestParam("mychar") char x)
	{
		return studentservice.getStudentsWhoseNameStartWithUDChar(x);
	}
	
	@DeleteMapping("/deleteStudentById/{studrno}")
	public String deleteStudentById(@PathVariable("studrno") int rno)
	{
		studentservice.deleteStudentById(rno);
		return "Record Deleted Successfully";
	}
	
	@PutMapping("/updateStudentById/{studrno}")
	public Student updateStudentById(@PathVariable("studrno") int rno, @RequestBody Student studentfromfe)
	{
		return studentservice.updateStudentById(rno,studentfromfe);
	}
	
//	@PostMapping("/addBatchOfStudent")
//	public List<Student> addBatchOfStudent(@RequestBody List<Student> students)
//	{
//		return  studentservice.addBatchOfStudent(students);
//		//"Student Record Addedd successfully";
//	}
	
	public void demo()
	{
		Teacher t1=new Teacher();
		t1.setUsername("alice@gmail.com");
		t1.setPassword("alice123");
		
		Teacher t2=Teacher.builder()
				.username("ben@gmail.com")
				.password("ben123")
				.build();
	}
	
	
	@PostMapping("/addMultipleStudents")
	public List<Student> addMultipleStudents(@RequestBody List<Student> students)
	{
		return studentservice.addMultipleStudents(students);
	}
	
	
	@PostMapping("/addStudentsFromJSONFIle")
	public List<Student> addStudentsFromJSONFIle()
	{
		return studentservice.addStudentsFromJSONFIle();
	}
	
	@PostMapping("/addproductsFromJSONFIle")
	public List<Product> addproductsFromJSONFIle()
	{
		return productservice.addproductsFromJSONFIle();
	}
	
	
	@PostMapping("/addAmazonproductsFromJSONFIle")
	public List<AmazonProducts> addAmazonproductsFromJSONFIle()
	{
		return amazonproductservice.addAmazonproductsFromJSONFIle();
	}
	
	
	
//	@PostMapping("/addStudentFromJson")
//	public List<Student> addStudentFromJson() 
//	{
//		return  studentservice.addStudentFromJson();
//		//"Student Record Addedd successfully";
//	}
}
