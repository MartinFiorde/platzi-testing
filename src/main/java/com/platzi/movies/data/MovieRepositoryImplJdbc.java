package com.platzi.movies.data;

import com.platzi.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class MovieRepositoryImplJdbc implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    public MovieRepositoryImplJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        String sql = "SELECT * FROM movies WHERE id = ?;";
        return jdbcTemplate.queryForObject(sql, getMovieRowMapper(), id);
    }

    @Override
    public List<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies;", getMovieRowMapper());
    }

    @Override
    public Movie saveOrUpdate(Movie movie) {
        Movie movieSaved = new Movie(movie.getId(), movie.getName(), movie.getMinutes(), movie.getGenre());
        if (movieSaved.getId() == null || movieSaved.getId() == 0 || findById(movieSaved.getId()) == null) {
            String insertSql = "INSERT INTO movies (name, minutes, genre) VALUES (?, ?, ?);";
            //jdbcTemplate.update(insertSql, movieSaved.getName(), movieSaved.getMinutes(), movieSaved.getGenre().name());
            KeyHolder keyHolder = new GeneratedKeyHolder();

            // Ejecutar el INSERT y capturar la clave generada
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(insertSql, new String[]{"id"});
                ps.setString(1, movieSaved.getName());
                ps.setInt(2, movieSaved.getMinutes());
                ps.setString(3, movieSaved.getGenre().name());
                return ps;
            }, keyHolder);

            // Obtener el ID generado y asignarlo al objeto movieSaved
            int newId = Objects.requireNonNull(keyHolder.getKey()).intValue();
            movieSaved.setId(newId);

        } else {
            String updateSql = "UPDATE movies SET name = ?, minutes = ?, genre = ? WHERE id = ?;";
            jdbcTemplate.update(updateSql, movieSaved.getName(), movieSaved.getMinutes(), movieSaved.getGenre().name(), movieSaved.getId());
        }
        return movieSaved;
    }

    private static RowMapper<Movie> getMovieRowMapper() {
        return new RowMapper<>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Movie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("minutes"),
                        Movie.Genre.valueOf(rs.getString("genre"))
                );
            }
        };
    }
}
