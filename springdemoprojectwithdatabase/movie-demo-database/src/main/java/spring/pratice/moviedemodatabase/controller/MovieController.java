package spring.pratice.moviedemodatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.implementation.bind.annotation.Default;
import spring.pratice.moviedemodatabase.model.Movie;
import spring.pratice.moviedemodatabase.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping(value = "add/movies", method = RequestMethod.POST)
	public boolean addMovies(@RequestBody Movie m) {
		return movieService.addMovies(m);
	}

	@RequestMapping(value = "get/movies", method = RequestMethod.GET)
	public List<Movie> getMovies(@RequestParam(defaultValue = "") String id) {
		if (id.isEmpty()) {
			return getallMovies();
		}
		return (List<Movie>) movieService.getMovies(Integer.parseInt(id));
	}

	@RequestMapping(value = "remove/movie/{id}", method = RequestMethod.DELETE)
	public boolean removeEmployee(@PathVariable int id) {
		return movieService.removeMovies(id);
	}

	@RequestMapping(value = "getall/movies", method = RequestMethod.GET)
	public List<Movie> getallMovies() {
		return movieService.getallMovies();
	}

	@RequestMapping(value = "update/movie/{id}", method = RequestMethod.PUT)
	public Movie updateMovie(@PathVariable int id, Movie mv) {

		return updateMovie(id, mv);
	}
	
}
