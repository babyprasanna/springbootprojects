package spring.pratice.studentdemo.service;

import java.util.Comparator;

import spring.pratice.studentdemo.model.Student;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		return (o1.getName().compareTo(o2.getName()));
	}

}
