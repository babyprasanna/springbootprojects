package spring.pratice.studentdemorelations.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import spring.pratice.studentdemorelations.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
