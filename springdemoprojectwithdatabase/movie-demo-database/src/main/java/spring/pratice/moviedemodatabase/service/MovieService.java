package spring.pratice.moviedemodatabase.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import spring.pratice.moviedemodatabase.model.Movie;
import spring.pratice.moviedemodatabase.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	public boolean addMovies(Movie m) {

		List<Movie> movielist = (List<Movie>) movieRepository.findAll();

		for (Movie mv : movielist) {
			if (mv.getId() == m.getId()) {
				try {
					throw new RuntimeException();
				} catch (Exception e) {
					throw new ResponseStatusException(HttpStatus.CONFLICT, "Id Present in DataBase" + m.getId());
				}
			}
		}
		movieRepository.save(m);
		return true;

	}

	public Movie getMovies(int id) {

		Optional<Movie> op = movieRepository.findById(id);

		if (op.isPresent()) {
			return op.get();
		} else {
			try {
				throw new RuntimeException("Error Occured");
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}
	}

	public List<Movie> getallMovies() {

		return (List<Movie>) movieRepository.findAll();
	}

	public void updateMovie(int id, Movie s) {

		removeMovies(id);
		addMovies(s);

	}

	public boolean removeMovies(int id) {

		Optional<Movie> op = movieRepository.findById(id);

		if (op.isPresent()) {
			movieRepository.deleteById(id);
			return true;
		} else {
			try {
				throw new RuntimeException("Error Occure");
			} catch (RuntimeException e) {

				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is Not Found " + id);
			}
		}
	}
}
