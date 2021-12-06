package spring.pratice.employeedemodatabase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import spring.pratice.employeedemodatabase.model.Employee;
import spring.pratice.employeedemodatabase.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public boolean addEmployee(Employee e) {
		List<Employee> emplist = (List<Employee>) employeeRepository.findAll();

		for (Employee emp : emplist) {
			if (emp.getId() == e.getId()) {
				try {
					throw new RuntimeException();
				} catch (Exception ex) {
					throw new ResponseStatusException(HttpStatus.CONFLICT, "Id Present in DataBase" + e.getId());
				}
			}
		}
		employeeRepository.save(e);
		return true;
	}

	public Employee getEmployee(int id) {

		Optional<Employee> op = employeeRepository.findById(id);

		if (op.isPresent()) {
			return op.get();
		} else {
			try {
				throw new RuntimeException();
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not Present in Database " + id);
			}
		}
	}

	public List<Employee> getallEmployee() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public void updateEmployee(int id, Employee e) {

		removeEmployee(id);
		addEmployee(e);
	}

	public boolean removeEmployee(int id) {

		Optional<Employee> op = employeeRepository.findById(id);

		if (op.isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		} else {
			try {
				throw new RuntimeException();
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not Present in Database");
			}
		}
	}

}
