package spring.pratice.employeedemodatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.pratice.employeedemodatabase.model.Employee;
import spring.pratice.employeedemodatabase.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "add/employee", method = RequestMethod.POST)
	public boolean addStudent(@RequestBody Employee e) {
		return employeeService.addEmployee(e);
	}

	@RequestMapping(value = "get/employee", method = RequestMethod.GET)
	public Employee getEmployee(@RequestParam int id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "getall/employee", method = RequestMethod.GET)
	public List<Employee> getallEmployee() {
		return employeeService.getallEmployee();
	}

	@RequestMapping(value = "remove/employee/{id}", method = RequestMethod.DELETE)
	public boolean removeEmployee(@PathVariable int id) {
		return employeeService.removeEmployee(id);
	}

	@RequestMapping(value = "update/employee/{id}", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable int id, Employee e) {
		employeeService.updateEmployee(id, e);
	}

}
