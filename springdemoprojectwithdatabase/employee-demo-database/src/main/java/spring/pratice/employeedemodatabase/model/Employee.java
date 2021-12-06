package spring.pratice.employeedemodatabase.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	private String role;
	private int salary;

	public Employee() {

	}

	public Employee(int id, String name, String role, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, role, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(role, other.role)
				&& salary == other.salary;
	}

}
