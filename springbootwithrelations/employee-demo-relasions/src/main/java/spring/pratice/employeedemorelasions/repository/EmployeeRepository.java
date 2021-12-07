package spring.pratice.employeedemorelasions.repository;

import org.springframework.data.repository.CrudRepository;

import spring.pratice.employeedemorelasions.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
