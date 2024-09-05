package com.platzi.movies.service;

import com.platzi.movies.data.MovieRepository;
import com.platzi.movies.model.Movie;

import java.util.List;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findMoviesByGenre(Movie.Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre)
                .toList();
    }

    public List<Movie> findMoviesByMaxOrEqualLength(int length) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length)
                .toList();
    }

    public List<Movie> findMoviesByPartialName(String partialName) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(partialName.toLowerCase()))
                .toList();
    }

    public Movie findMoviesByExactName(String exactName) {
        List<Movie> items = movieRepository.findAll().stream()
                .filter(movie -> movie.getName().equalsIgnoreCase(exactName))
                .toList();

        if (items.isEmpty()) throw new IllegalArgumentException("No movie found with the name " + exactName);
        if (items.size() > 1) throw new IllegalArgumentException("Multiple movies found with the name " + exactName);
        return items.getFirst();
    }
}
