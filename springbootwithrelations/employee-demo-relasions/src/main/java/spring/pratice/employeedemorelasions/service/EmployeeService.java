package spring.pratice.employeedemorelasions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import spring.pratice.employeedemorelasions.model.Designation;
import spring.pratice.employeedemorelasions.model.Employee;
import spring.pratice.employeedemorelasions.repository.DesignationRepository;
import spring.pratice.employeedemorelasions.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DesignationRepository designationRepository;

	public List<Employee> getEmployee(int id) {
		Optional<Employee> op = employeeRepository.findById(id);

		if (op.isPresent()) {
			List<Employee> emplist = new ArrayList<>();
			emplist.add(op.get());
			return emplist;
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}
	}

	public boolean addEmployee(Employee e) {

		List<Employee> emplist = (List<Employee>) employeeRepository.findAll();

		for (Employee em : emplist) {
			if (em.getEid() == e.getEid()) {
				try {
					throw new RuntimeException("Error Occured");

				} catch (RuntimeException ex) {
					throw new ResponseStatusException(HttpStatus.CONFLICT, "Id is present in database " + e.getEid());
				}
			}
		}
		employeeRepository.save(e);
		return true;
	}

	public List<Employee> getallEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public boolean removeEmployee(int id) {

		Optional<Employee> op = employeeRepository.findById(id);

		if (op.isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}
	}

	public void updateEmployee(int id, Employee e) {

		removeEmployee(id);
		addEmployee(e);

	}

	public List<Employee> getallStudents() {

		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee addEmployeeDesignation(int eid, int did) {

		Employee e = null;
		Designation d = null;

		Optional<Employee> op = employeeRepository.findById(eid);

		if (op.isPresent()) {
			e = op.get();
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + eid);
			}
		}

		Optional<Designation> op1 = designationRepository.findById(did);

		if (op1.isPresent()) {
			d = op1.get();
		} else {
			try {
				throw new RuntimeException("Error Occured");

			} catch (RuntimeException ex) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + did);
			}
		}
		e.setDesignation(d);
		List<Employee> elist = new ArrayList();
		elist.add(e);
		d.setEmployee(elist);

		employeeRepository.save(e);
		designationRepository.save(d);

		return e;

	}

}
