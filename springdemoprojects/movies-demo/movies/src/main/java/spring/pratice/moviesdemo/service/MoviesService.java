package spring.pratice.moviesdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.pratice.moviesdemo.model.Movies;

@Service
public class MoviesService {

	ArrayList<Movies> movielist = new ArrayList<>();

	public boolean addMovies(Movies m) {

		for (Movies mve : movielist) {
			if (mve.getId() == m.getId()) {
				return false;
			}

		}
		movielist.add(m);
		return true;
	}

	public List<Movies> getMovies(int id) {

		for (Movies mve : movielist) {
			if (mve.getId() == id) {
				return new ArrayList<Movies>(Collections.nCopies(1, mve));
			}
		}
		return null;
	}
	
	public ArrayList<Movies> getallMovies() {
		return movielist;
	}

	public boolean removeMovies(int id) {
		Movies temp = null;
		boolean find = false;
		for (Movies mve : movielist) {
			if (mve.getId() == id) {
				temp = mve;
				find = true;
			}
			if (find) {
				movielist.remove(temp);
			}
		}
		return find;
	}


	public Movies updateMovies(int id, Movies mv) {

		for (Movies mve : movielist) {
			Movies temp = null;
			boolean flag = false;
			if (mve.getId() == mv.getId()) {
				temp = mve;
				flag = true;
			}
			if (flag) {
				movielist.remove(temp);
			}
		}
		movielist.add(mv);
		return mv;
	}

	public List<Movies> sortMovieId() {
		Collections.sort(movielist, new IdComparator());
		return movielist;
	}

	public List<Movies> sortMovieName() {

		Collections.sort(movielist, new NameComparator());
		return movielist;
	}

	public List<Movies> sortMovieBudget() {

		Collections.sort(movielist, new BudgetComparator());
		return movielist;
	}

	public List<Movies> sortCollections() {

		Collections.sort(movielist, new BudgetComparator());
		return movielist;
	}

	private List<Movies> sortYear() {
		Collections.sort(movielist, new YearComparator());
		return movielist;
	}

	public List<Movies> sortMovie(String s) {
		if (s.isEmpty()) {
			return sortMovieId();
		} else if (s.equals("bedget")) {
			return sortMovieBudget();
		} else if (s.equals("collections")) {
			return sortCollections();
		} else if (s.equals("name")) {
			return sortMovieName();
		} else if (s.equals("year")) {
			return sortYear();
		} 
		return null;
	}

}