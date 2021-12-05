package spring.pratice.moviesdemo.service;

import java.util.Comparator;

import spring.pratice.moviesdemo.model.Movies;

public class CollectionsComparator implements Comparator<Movies> {

	@Override
	public int compare(Movies o1, Movies o2) {

		if (o1.getCollections() == o2.getCollections()) {
			return 0;
		} else if (o1.getCollections() > o2.getCollections()) {
			return 1;
		} else {
			return -1;
		}
	}

}
