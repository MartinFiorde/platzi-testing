package com.platzi.movies.data;

import com.platzi.movies.model.Movie;

import java.util.List;

public interface MovieRepository {
    Movie findById(Integer id);

    List<Movie> findAll();

    Movie saveOrUpdate(Movie movie);
}
