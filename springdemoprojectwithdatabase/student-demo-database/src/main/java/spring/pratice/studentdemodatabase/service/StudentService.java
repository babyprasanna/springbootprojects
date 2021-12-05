package spring.pratice.studentdemodatabase.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import spring.pratice.studentdemodatabase.model.Student;
import spring.pratice.studentdemodatabase.repository.*;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student getStudent(int id) {
		Optional<Student> op = studentRepository.findById(id);

		if (op.isPresent()) {
			return op.get();
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}
	}

	public boolean addStudent(Student s) {

		List<Student> stulist = (List<Student>) studentRepository.findAll();

		for (Student st : stulist) {
			if (st.getId() == s.getId()) {
				try {
					throw new RuntimeException("Error Occured");

				} catch (RuntimeException e) {
					throw new ResponseStatusException(HttpStatus.CONFLICT, "Id is present in database " + s.getId());
				}
			}
		}
		studentRepository.save(s);
		return true;
	}

	public List<Student> getallStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	public boolean removeStudent(int id) {

		Optional<Student> op = studentRepository.findById(id);

		if (op.isPresent()) {
			studentRepository.deleteById(id);
			return true;
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}
	}

	public void updateStudent(int id, Student s) {

		removeStudent(id);
		addStudent(s);

	}

}
