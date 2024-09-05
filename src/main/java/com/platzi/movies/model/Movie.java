package com.platzi.movies.model;

import java.util.Objects;

public class Movie {
    public enum Genre {ACTION, COMEDY, DRAMA, HORROR, THRILLER}

    private Integer id;
    private final String name;
    private final int minutes;
    private final Genre genre;

    public Movie(String name, int minutes, Genre genre) {
        this(null, name, minutes, genre);
    }

    public Movie(Integer id, String name, int minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
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
        return minutes == movie.minutes && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minutes=" + minutes +
                ", genre=" + genre +
                '}';
    }
}
