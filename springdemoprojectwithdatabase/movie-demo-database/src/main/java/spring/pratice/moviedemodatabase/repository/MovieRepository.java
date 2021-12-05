package spring.pratice.moviedemodatabase.repository;

import org.springframework.data.repository.CrudRepository;

import spring.pratice.moviedemodatabase.model.Movie;


public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
