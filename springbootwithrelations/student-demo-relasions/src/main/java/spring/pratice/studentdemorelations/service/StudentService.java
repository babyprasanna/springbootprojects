package spring.pratice.studentdemorelations.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import spring.pratice.studentdemorelations.model.Branch;
import spring.pratice.studentdemorelations.model.Student;
import spring.pratice.studentdemorelations.repository.BranchRepository;
import spring.pratice.studentdemorelations.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	BranchRepository branchRepository;

	public List<Student> getStudent(int id) {
		Optional<Student> op = studentRepository.findById(id);

		if (op.isPresent()) {
			List<Student> stlist = new ArrayList<>();
			stlist.add(op.get());
			return stlist;
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
			if (st.getSid() == s.getSid()) {
				try {
					throw new RuntimeException("Error Occured");

				} catch (RuntimeException e) {
					throw new ResponseStatusException(HttpStatus.CONFLICT, "Id is present in database " + s.getSid());
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

	public Student addStudentBranch(int sid, int bid) {

		Student s = null;
		Branch b = null;

		Optional<Student> op = studentRepository.findById(sid);

		if (op.isPresent()) {
			s = op.get();
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + sid);
			}
		}

		Optional<Branch> op1 = branchRepository.findById(bid);

		if (op1.isPresent()) {
			b = op1.get();
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + bid);
			}
		}
		s.setBranch(b);
		List<Student> slist = new ArrayList();
		slist.add(s);
		b.setStudent(slist);
		
		studentRepository.save(s);
		branchRepository.save(b);

		return s;

	}

}
