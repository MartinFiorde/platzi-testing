package com.platzi.movies.service;

import com.platzi.movies.data.MovieRepository;
import com.platzi.movies.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.platzi.movies.model.Movie.Genre.*;
import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    private MovieRepository mockedRepository = Mockito.mock(MovieRepository.class);
    private MovieService service;

    @Test
    void return_movies_by_genre() {
        Mockito.when(mockedRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "There's Something About Mary", 119, COMEDY),
                new Movie(4, "Super 8", 112, THRILLER),
                new Movie(5, "Scream", 111, HORROR),
                new Movie(6, "Home Alone", 103, COMEDY),
                new Movie(7, "Matrix", 136, ACTION)
        ));
        service = new MovieService(mockedRepository);

        Collection<Movie> movies = service.findMoviesByGenre(COMEDY);
        List<Integer> movieIds = movies.stream().map(Movie::getId).toList();

        assertEquals(List.of(3, 6), movieIds);
    }
}