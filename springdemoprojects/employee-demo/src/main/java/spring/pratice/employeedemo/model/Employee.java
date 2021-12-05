package spring.pratice.employeedemo.model;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private String role;
	private String companyname;
	private long salary;

	public Employee() {
	}

	public Employee(int id, String name, String role, String companyname, long salary) {

		this.id = id;
		this.name = name;
		this.role = role;
		this.companyname = companyname;
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

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", companyname=" + companyname + ", salary="
				+ salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyname, id, name, role, salary);
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
		return Objects.equals(companyname, other.companyname) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(role, other.role) && salary == other.salary;
	}

	@Override
	public int compareTo(Employee e) {

		if (id == e.getId()) {
			return 0;
		} else if (id > e.getId()) {
			return 1;
		} else {
			return -1;
		}
	}

}
