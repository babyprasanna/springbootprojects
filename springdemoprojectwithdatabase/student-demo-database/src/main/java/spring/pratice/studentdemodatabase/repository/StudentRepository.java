package spring.pratice.studentdemodatabase.repository;

import org.springframework.data.repository.CrudRepository;

import spring.pratice.studentdemodatabase.model.Student;


public interface StudentRepository extends CrudRepository<Student, Integer> {
	
}
