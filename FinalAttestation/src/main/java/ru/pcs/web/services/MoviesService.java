package ru.pcs.web.services;

import ru.pcs.web.forms.MovieForm;
import ru.pcs.web.models.Actor;
import ru.pcs.web.models.Movie;

import java.util.List;

public interface MoviesService {
    void addMovie(MovieForm form);
    List<Movie> getAllMovies();
    void deleteMovie(Integer movieId);
    Movie getMovie(Integer movieId);
    void addActorToMovie(Integer movieId, Integer actorId);
    void update(Integer movieId, MovieForm movieForm);
    List<Actor> getActorsNotInAMovie (Integer movieId);
}
