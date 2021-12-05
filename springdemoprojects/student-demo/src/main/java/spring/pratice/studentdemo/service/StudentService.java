package spring.pratice.studentdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.pratice.studentdemo.model.Student;

@Service
public class StudentService {

	ArrayList<Student> stulist = new ArrayList();

	public boolean addStudent(Student s) {

		for (Student std : stulist) {
			if (std.getId() == s.getId()) {
				return false;
			}
		}
		stulist.add(s);
		return true;
	}

	public Student getStudent(int id) {
		for (Student s : stulist) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}

	public boolean removeStudent(int id) {

		Student temp = null;
		boolean find = false;

		for (Student s : stulist) {
			if (s.getId() == id) {
				temp = s;
				find = true;
			}
		}
		if (find) {
			stulist.remove(temp);
		}
		return find;
	}

	public Student updateStudent(int id, Student stu) {
		Student temp = null;
		boolean flag = false;
		for (Student std : stulist) {
			if (std.getId() == id) {

				temp = std;
				flag = true;
				break;
			}
		}
		if (flag) {
			stulist.remove(temp);
		}
		stulist.add(stu);
		return stu;
	}

	public List<Student> getallStudents() {
		return stulist;
	}

	public List<Student> sortStudent() {
		Collections.sort(stulist);
		return stulist;
	}

	public List<Student> sortStudentName() {
		Collections.sort(stulist, new StudentComparator());
		return stulist;
	}

}
