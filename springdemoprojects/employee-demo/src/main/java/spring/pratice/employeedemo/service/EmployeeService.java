package spring.pratice.employeedemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.pratice.employeedemo.model.Employee;

@Service
public class EmployeeService {

	ArrayList<Employee> emp = new ArrayList();

	public boolean addEmployee(Employee e) {

		for (Employee emp : emp) {
			if (emp.getId() == e.getId()) {
				return false;
			}
		}
		emp.add(e);
		return true;
	}

	public Employee getEmployee(int id) {

		for (Employee employee : emp) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}

	public List<Employee> getallEmployee() {

		return emp;
	}

	public boolean removeEmployee(int id) {

		Employee temp = null;
		boolean find = false;
		for (Employee employee : emp) {
			if (employee.getId() == id) {
				temp = employee;
				find = true;
			}
			if (find) {
				emp.remove(temp);
			}
		}
		return find;
	}

	public Employee updateEmployee(int id, Employee e) {

		Employee temp = null;
		boolean flag = false;

		for (Employee employee : emp) {
			if (employee.getId() == id) {
				temp = employee;
				flag = true;
				break;
			}
		}
		if (flag) {
			emp.remove(temp);
		}
		emp.add(e);
		return e;

	}

	public List<Employee> sortEmployee() {

		Collections.sort(emp);
		return emp;

	}

	public List<Employee> sortEmployeeSalary() {
		Collections.sort(emp, Comparator.comparingLong(Employee::getSalary));
		
		return emp;
	}
}
