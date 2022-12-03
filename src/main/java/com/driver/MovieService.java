package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movierepository;
    public void addMovie(Movie movie) {
        movierepository.saveMovie(movie);
    }

    public void addDirector(Director director) {
        movierepository.saveDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director) {
        movierepository.saveMovieDirectorPair(movie,director);
    }

    public Movie findmovie(String movieName) {
        return movierepository.findMovie(movieName);
    }

    public Director findDirector(String directorName) {
        return movierepository.findDirector(directorName);
    }

    public List<String> findMoviesByDirectorName(String director) {
        return movierepository.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies() {
        return movierepository.findAllMovies();
    }

    public void deleteDirector(String director) {
        movierepository.deleteDirector(director);
    }

    public void deleteAllDirectors() {
        movierepository.deleteAllDirectors();
    }
}
