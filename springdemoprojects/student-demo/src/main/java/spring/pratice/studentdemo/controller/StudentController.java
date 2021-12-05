package spring.pratice.studentdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.pratice.studentdemo.model.Student;
import spring.pratice.studentdemo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/get/student/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable int id) {

		return studentService.getStudent(id);

	}

	@RequestMapping(value = "add/student", method = RequestMethod.POST)
	public boolean addStudent(@RequestBody Student s) {
		return studentService.addStudent(s);
	}

	@RequestMapping(value = "/get/students", method = RequestMethod.GET)
	public List<Student> getallStudents() {

		return studentService.getallStudents();
	}

	@RequestMapping(value = "delete/student/{id}", method = RequestMethod.DELETE)
	public boolean removeStudent(@PathVariable int id) {
		return studentService.removeStudent(id);
	}

	@RequestMapping(value = "update/student/{id}", method = RequestMethod.PUT)
	public void updateStudent(@PathVariable int id, @RequestBody Student s) {
		studentService.updateStudent(id, s);
	}

	@RequestMapping(value = "sort/student", method = RequestMethod.GET)
	public List<Student> sortStudent() {

		return studentService.sortStudent();

	}

	@RequestMapping(value = "sort/student/name", method = RequestMethod.GET)
	public List<Student> sortStudentName() {
		return studentService.sortStudentName();
	}

}
