package spring.pratice.moviesdemo.service;

import java.util.Comparator;

import spring.pratice.moviesdemo.model.Movies;

public class IdComparator implements Comparator<Movies> {

	@Override
	public int compare(Movies o1, Movies o2) {

		if (o1.getId() == o2.getId()) {
			return 0;
		} else if (o1.getId() > o2.getId()) {
			return 1;
		} else {
			return -1;
		}

	}

}
