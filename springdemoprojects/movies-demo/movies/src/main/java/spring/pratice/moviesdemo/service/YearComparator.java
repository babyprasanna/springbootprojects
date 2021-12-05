package spring.pratice.moviesdemo.service;

import java.util.Comparator;

import spring.pratice.moviesdemo.model.Movies;

public class YearComparator implements Comparator<Movies> {

	@Override
	public int compare(Movies o1, Movies o2) {
		if (o1.getYear() == o2.getYear()) {
			return 0;
		} else if (o1.getYear() > o2.getYear()) {
			return 1;
		} else {
			return -1;
		}
	}

}
