package spring.pratice.moviesdemo.service;

import java.util.Comparator;

import spring.pratice.moviesdemo.model.Movies;

public class NameComparator implements Comparator<Movies> {

	@Override
	public int compare(Movies o1, Movies o2) {

		return o1.getName().compareTo(o2.getName());
	}

}
