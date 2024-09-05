package com.platzi.movies.data;

import com.platzi.movies.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.util.List;

import static com.platzi.movies.model.Movie.Genre.*;
import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryIntegrationTest {

    private MovieRepositoryImplJdbc movieRepository;
    @BeforeEach
    void setUp() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                "jdbc:h2:mem:test;MODE=MYSQL",
                "testuser",
                "testpass"
        );

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate template = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryImplJdbc(template);

    }

    @Test
    void load_all_movies() {
        List<Movie> result = movieRepository.findAll();
        assertEquals(getExpected(), result);
    }

    private static List<Movie> getExpected() {
        return List.of(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "Matrix", 136, ACTION)
        );
    }

    @Test
    void load_movie_by_id() {
        Movie expected = new Movie(1, "Dark Knight", 152, ACTION);
        Movie result = movieRepository.findById(1);
        assertEquals(expected, result);
    }

    @Test
    void save_new_movie() {
        Movie result = movieRepository.saveOrUpdate(new Movie("Pepito", 89, COMEDY));
        Movie expected = new Movie(4, "Pepito", 89, COMEDY);
        assertEquals(expected, result);
    }

    @Test
    void update_existing_movie() {
        Movie expected = new Movie(1, "Dark Knight", 152, THRILLER);
        Movie result = movieRepository.saveOrUpdate(new Movie(1, "Dark Knight", 152, THRILLER));
        assertEquals(expected, result);
    }
}