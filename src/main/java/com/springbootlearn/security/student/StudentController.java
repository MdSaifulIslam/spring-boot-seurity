package com.springbootlearn.security.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

	private static final List<Student> students = Arrays.asList(new Student(1, "Saiful"), new Student(2, "Sakib"),
			new Student(3, "Jamal"));

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable Integer studentId) {
		
		return students.stream()
		.filter(student -> studentId.equals(student.getId()))
		.findFirst()
		.orElseThrow(()-> new IllegalStateException("Not Found"));
	}

}
