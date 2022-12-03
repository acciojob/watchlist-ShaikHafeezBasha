package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private HashMap<String,Movie>moiveMap;
    private HashMap<String,Director>directorMap;
    private HashMap<String, List<String>>directormovieMapping;

    public MovieRepository() {
        this.moiveMap=new HashMap<String, Movie>();
        this.directorMap=new HashMap<String, Director>();
        this.directormovieMapping=new HashMap<String, List<String>>();
    }
    public void saveMovie(Movie movie) {
        moiveMap.put(movie.getName(),movie);
    }
    public void saveDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director) {
        if(moiveMap.containsKey(movie) && directorMap.containsKey(director)){
            moiveMap.put(movie, moiveMap.get(movie));
            directorMap.put(director, directorMap.get(director));
            List<String> currentMovies = new ArrayList<String>();
            if(directormovieMapping.containsKey(director)) currentMovies = directormovieMapping.get(director);
            currentMovies.add(movie);
            directormovieMapping.put(director, currentMovies);
        }
    }

    public Movie findMovie(String movieName) {
        return moiveMap.get(movieName);
    }

    public Director findDirector(String directorName) {
        return directorMap.get(directorName);
    }

    public List<String> findMoviesFromDirector(String director) {
        List<String>movieList=new ArrayList<>();
        if(directormovieMapping.containsKey(director)){
            movieList=directormovieMapping.get(director);
        }
        return movieList;
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(moiveMap.keySet());
    }

    public void deleteDirector(String director) {
        List<String>movies=new ArrayList<>();
        if(directormovieMapping.containsKey(director)) {
            movies = directormovieMapping.get(director);
            for (String movie : movies) {
                if (moiveMap.containsKey(movie)) {
                    moiveMap.remove(movie);
                }
            }
            directormovieMapping.remove(director);
        }
        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }
    public void deleteAllDirectors() {
        HashSet<String>moviesSet=new HashSet<>();
        for(String director:directormovieMapping.keySet()){
            for(String movie:directormovieMapping.get(director)){
                moviesSet.add(movie);
            }
        }
        for(String movie:moviesSet){
            if(directormovieMapping.containsKey(movie)){
                moiveMap.remove(movie);
            }
        }
    }
}
