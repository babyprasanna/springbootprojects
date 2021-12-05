package spring.pratice.moviesdemo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import spring.pratice.moviesdemo.model.Movies;
import spring.pratice.moviesdemo.service.MoviesService;

@RestController
public class MoviesController {

	@Autowired
	MoviesService moviesService;

	@RequestMapping(value = "add/movies", method = RequestMethod.POST)
	public boolean addMovies(@RequestBody Movies m) {
		return moviesService.addMovies(m);
	}

	@RequestMapping(value = "get/movies", method = RequestMethod.GET)
	public List<Movies> getMovies(@RequestParam(defaultValue = "") String id) {
		if (id.isEmpty()) {
			return getallMovies();
		}
		return moviesService.getMovies(Integer.parseInt(id));
	}

	@RequestMapping(value = "remove/movie/{id}", method = RequestMethod.DELETE)
	public boolean removeEmployee(@PathVariable int id) {
		return moviesService.removeMovies(id);
	}

	@RequestMapping(value = "getall/movies", method = RequestMethod.GET)
	public List<Movies> getallMovies() {
		return moviesService.getallMovies();
	}

	@RequestMapping(value = "update/movie/{id}", method = RequestMethod.PUT)
	public Movies updateMovie(@PathVariable int id, Movies mv) {

		return updateMovie(id, mv);
	}

	@RequestMapping(value = "sort/movie", method = RequestMethod.GET)
	public List<Movies> sortMovie(@RequestParam(defaultValue = "") String s) {
		return moviesService.sortMovie(s);

	}

}
