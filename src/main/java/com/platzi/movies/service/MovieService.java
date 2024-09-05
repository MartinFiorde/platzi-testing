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

    public List<Movie> findMoviesByExactDirector(String director) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().equalsIgnoreCase(director))
                .toList();
    }

    public List<Movie> findMoviesByTemplate(Movie template) {
        if (template.getId() != null) {
            Movie asd = movieRepository.findById(template.getId());
            System.out.println(asd);
            return List.of(movieRepository.findById(template.getId()));
        }
        if (template.getMinutes() != null && template.getMinutes() < 0) throw new IllegalArgumentException("Minutes cannot be negative");
        return movieRepository.findAll().stream()
                .filter(movie -> template.getName() == null
                        || movie.getName().toLowerCase().contains(template.getName().toLowerCase()))
                .filter(movie -> template.getDirector() == null
                        || movie.getDirector().equalsIgnoreCase(template.getDirector()))
                .filter(movie -> template.getMinutes() == null
                        || movie.getMinutes() <= template.getMinutes())
                .filter(movie -> template.getGenre() == null
                        || movie.getGenre() == template.getGenre())
                .toList();
    }
}
