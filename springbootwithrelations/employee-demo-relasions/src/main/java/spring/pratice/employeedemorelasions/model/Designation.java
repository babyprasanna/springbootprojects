package spring.pratice.employeedemorelasions.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Designation {

	@Id
	private int did;
	private String dname;

	@OneToMany(mappedBy = "designation")
	@JsonBackReference
	private List<Employee> employee;

	public Designation() {

	}

	public Designation(int did, String dname, List<Employee> employee) {
		super();
		this.did = did;
		this.dname = dname;
		this.employee = employee;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Designation [did=" + did + ", dname=" + dname + ", employee=" + employee + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(did, dname, employee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Designation other = (Designation) obj;
		return did == other.did && Objects.equals(dname, other.dname) && Objects.equals(employee, other.employee);
	}

}
