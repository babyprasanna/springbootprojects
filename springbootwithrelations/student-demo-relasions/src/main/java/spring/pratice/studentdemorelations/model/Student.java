package spring.pratice.studentdemorelations.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student {

	@Id
	private int sid;
	private String sname;

	@ManyToOne
	@JsonManagedReference
	private Branch branch;

	public Student() {

	}

	public Student(int sid, String sname, Branch branch) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.branch = branch;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", branch=" + branch + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(branch, sid, sname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(branch, other.branch) && sid == other.sid && Objects.equals(sname, other.sname);
	}

}
