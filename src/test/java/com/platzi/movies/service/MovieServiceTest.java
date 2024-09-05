package com.platzi.movies.service;

import com.platzi.movies.data.MovieRepository;
import com.platzi.movies.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static com.platzi.movies.model.Movie.Genre.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MovieServiceTest {

    private MovieService service;

    @BeforeEach
    void setUp() {
        MovieRepository mockedRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(mockedRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "There's Something About Mary", 119, COMEDY),
                new Movie(4, "Super 8", 112, THRILLER),
                new Movie(5, "Scream", 111, HORROR),
                new Movie(6, "Home Alone", 103, COMEDY),
                new Movie(7, "Matrix", 136, ACTION),
                new Movie(8, "Matrix", 15, ACTION)
        ));
        service = new MovieService(mockedRepository);
    }

    @Test
    void return_movies_id_by_genre() {
        List<Movie> moviesInput = service.findMoviesByGenre(COMEDY);
        List<Integer> result = moviesInput.stream().map(Movie::getId).toList();
        assertThat(result).containsExactlyInAnyOrderElementsOf(List.of(6, 3));
    }

    @Test
    void return_movies_id_by_max_or_equal_length() {
        List<Movie> moviesInput = service.findMoviesByMaxOrEqualLength(119);
        List<Integer> result = moviesInput.stream().map(Movie::getId).toList();
        assertThat(result).containsExactlyInAnyOrderElementsOf(List.of(2, 3, 4, 5, 6, 8));
    }

    @Test
    void return_movies_id_by_partial_name() {
        List<Movie> moviesInput = service.findMoviesByPartialName("er");
        List<Integer> result = moviesInput.stream().map(Movie::getId).toList();
        assertThat(result).containsExactlyInAnyOrderElementsOf(List.of(3, 4));
    }

    @Test
    void return_movies_id_by_exact_name() {
        Movie result = service.findMoviesByExactName("Scream");
        assertEquals(5, result.getId());
    }

    @Test
    void throw_error_by_exact_name_not_existing() {
        assertThrows(IllegalArgumentException.class, () -> service.findMoviesByExactName("invalid exact name"));
    }

    @Test
    void throw_error_by_exact_name_existing_multiple_times() {
        assertThrows(IllegalArgumentException.class, () -> service.findMoviesByExactName("Matrix"));
    }

}