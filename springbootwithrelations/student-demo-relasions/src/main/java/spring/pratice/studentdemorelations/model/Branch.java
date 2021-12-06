package spring.pratice.studentdemorelations.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Branch {

	@Id
	private int bid;
	private String bname;

	@OneToMany(mappedBy = "branch")
	@JsonBackReference
	private List<Student> student;

	public Branch() {

	}

	public Branch(int bid, String bname, List<Student> student) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.student = student;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Branch [bid=" + bid + ", bname=" + bname + ", student=" + student + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bid, bname, student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		return bid == other.bid && Objects.equals(bname, other.bname) && Objects.equals(student, other.student);
	}

}
