package spring.pratice.studentdemo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Comparable<Student> {

	@Id
	private int id;
	private String name;
	private String address;
	private String gender;

	public Student() {

	}

	public Student(int id, String name, String address, String gender) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, gender, id, name);
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
		return Objects.equals(address, other.address) && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Student s) {

		if (id == s.getId()) {
			return 0;
		} else if (id > s.getId()) {
			return 1;
		} else {
			return -1;
		}

	}

}
