package spring.pratice.employeedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.pratice.employeedemo.model.Employee;
import spring.pratice.employeedemo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "get/employee/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "add/employee", method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody Employee e) {
		return employeeService.addEmployee(e);
	}

	@RequestMapping(value = "getall/employees", method = RequestMethod.GET)
	public List<Employee> getallEmployees() {

		return employeeService.getallEmployee();

	}

	@RequestMapping(value = "delete/employee/{id}", method = RequestMethod.DELETE)
	public boolean removeEmployee(@PathVariable int id) {
		return employeeService.removeEmployee(id);

	}

	@RequestMapping(value = "update/employee/{id}", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable int id, @RequestBody Employee e) {
		employeeService.updateEmployee(id, e);
	}

	@RequestMapping(value = "sort/employee", method = RequestMethod.GET)
	public List<Employee> sortEmployee() {

		return employeeService.sortEmployee();
	}

	@RequestMapping(value = "sort/employee/salary", method = RequestMethod.GET)
	public List<Employee> sortEmployeeSalary() {
		return employeeService.sortEmployeeSalary();
	}
}