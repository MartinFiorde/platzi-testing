package com.platzi.movies.model;

import java.util.Objects;

public class Movie {
    public enum Genre {ACTION, COMEDY, DRAMA, HORROR, THRILLER}

    private Integer id;
    private final String name;
    private final String director;
    private final Integer minutes;
    private final Genre genre;

    public Movie(String name, String director, int minutes, Genre genre) {
        this.name = name;
        this.director = director;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Movie(Integer id, String name, String director, Integer minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(minutes, movie.minutes) && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(director, movie.director) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, director, minutes, genre);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", minutes=" + minutes +
                ", genre=" + genre +
                '}';
    }
}
