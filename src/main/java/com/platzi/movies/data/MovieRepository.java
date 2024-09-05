package com.platzi.movies.data;

import com.platzi.movies.model.Movie;

import java.util.List;

public interface MovieRepository {
    Movie findById(long id);

    List<Movie> findAll();

    Movie saveOrUpdate(Movie movie);
}
