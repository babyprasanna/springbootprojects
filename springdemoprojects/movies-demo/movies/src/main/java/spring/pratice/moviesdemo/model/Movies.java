package spring.pratice.moviesdemo.model;

import java.util.Objects;

public class Movies {

	private int id;
	private String name;
	private int year;
	private int budget;
	private int collections;

	public Movies() {

	}

	public Movies(int id, String name, int year, int budget, int collections) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.budget = budget;
		this.collections = collections;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getCollections() {
		return collections;
	}

	public void setCollections(int collections) {
		this.collections = collections;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", name=" + name + ", year=" + year + ", budget=" + budget + ", collections="
				+ collections + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(budget, collections, id, name, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		return budget == other.budget && collections == other.collections && id == other.id
				&& Objects.equals(name, other.name) && year == other.year;
	}

}
