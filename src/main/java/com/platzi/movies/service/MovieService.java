package com.platzi.movies.service;

import com.platzi.movies.data.MovieRepository;
import com.platzi.movies.model.Movie;

import java.util.Collection;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Movie.Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre)
                .toList();
    }
}
