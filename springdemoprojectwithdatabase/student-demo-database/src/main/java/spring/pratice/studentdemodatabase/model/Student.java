package spring.pratice.studentdemodatabase.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int id;
	private String name;
	private String gender;
	private int marks;
	private String gread;

	public Student() {
	}

	public Student(int id, String name, String gender, int marks, String gread) {

		this.id = id;
		this.name = name;
		this.gender = gender;
		this.marks = marks;
		this.gread = gread;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getGread() {
		return gread;
	}

	public void setGread(String gread) {
		this.gread = gread;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", marks=" + marks + ", gread=" + gread
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, gread, id, marks, name);
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
		return Objects.equals(gender, other.gender) && Objects.equals(gread, other.gread) && id == other.id
				&& marks == other.marks && Objects.equals(name, other.name);
	}

}
