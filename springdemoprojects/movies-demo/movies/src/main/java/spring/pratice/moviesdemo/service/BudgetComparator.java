package spring.pratice.moviesdemo.service;

import java.util.Comparator;

import spring.pratice.moviesdemo.model.Movies;

public class BudgetComparator implements Comparator<Movies> {

	@Override
	public int compare(Movies o1, Movies o2) {

		if (o1.getBudget() == o2.getBudget()) {
			return 0;
		} else if (o1.getBudget() > o2.getBudget()) {
			return 1;
		} else {
			return -1;
		}
	}

}
