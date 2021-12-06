package spring.pratice.employeedemodatabase.repository;

import org.springframework.data.repository.CrudRepository;

import spring.pratice.employeedemodatabase.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
