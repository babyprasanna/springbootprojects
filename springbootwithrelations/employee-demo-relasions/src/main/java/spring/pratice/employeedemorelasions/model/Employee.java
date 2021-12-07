package spring.pratice.employeedemorelasions.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {

	@Id
	private int eid;
	private String ename;

	@ManyToOne
	@JsonManagedReference
	@JsonIgnore
	private Designation designation;

	public Employee() {

	}

	public Employee(int eid, String ename, Designation designation) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.designation = (Designation) designation;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", designation=" + designation + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(designation, eid, ename);
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
		return Objects.equals(designation, other.designation) && eid == other.eid && Objects.equals(ename, other.ename);
	}

}
