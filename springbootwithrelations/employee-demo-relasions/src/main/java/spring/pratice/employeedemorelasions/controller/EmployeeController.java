package spring.pratice.employeedemorelasions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.pratice.employeedemorelasions.model.Employee;
import spring.pratice.employeedemorelasions.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "add/employee", method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody Employee e) {
		return employeeService.addEmployee(e);
	}

	@RequestMapping(value = "get/employee", method = RequestMethod.GET)
	public List<Employee> getEmployee(@RequestParam(defaultValue = "-1") int id) {

		if (id == -1) {
			return employeeService.getallEmployees();
		} else {
			return employeeService.getEmployee(id);
		}
	}

	@RequestMapping(value = "getall/employees", method = RequestMethod.GET)
	public List<Employee> getallStudents() {

		return employeeService.getallStudents();
	}

	@RequestMapping(value = "delete/employee/{id}", method = RequestMethod.DELETE)
	public boolean removeEmployee(@PathVariable int id) {
		return employeeService.removeEmployee(id);
	}

	@RequestMapping(value = "update/employee/{id}", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable int id, @RequestBody Employee e) {
		employeeService.updateEmployee(id, e);
	}

	@RequestMapping(value = "employee/designation/{eid}/{did}", method = RequestMethod.GET)
	public Employee addEmployeeDesignation(@PathVariable int eid, @PathVariable int did) {
		return employeeService.addEmployeeDesignation(eid, did);
	}

}
