package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.exceptions.MovieNotFoundException;
import ru.pcs.web.forms.MovieForm;
import ru.pcs.web.models.Actor;
import ru.pcs.web.models.Movie;
import ru.pcs.web.repositories.ActorsRepository;
import ru.pcs.web.repositories.MoviesRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Component
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepository moviesRepository;
    private final ActorsRepository actorsRepository;

    @Override
    public void addMovie(MovieForm form) {
        Movie movie = Movie.builder()
                .title(form.getTitle())
                .releaseDate(LocalDate.parse(form.getReleaseDate()))
                .genre(form.getGenre())
                .mediumScore((double) 0)
                .build();
        moviesRepository.save(movie);

    }

    @Override
    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public void deleteMovie(Integer movieId) {
        moviesRepository.deleteById(movieId);
    }

    @Override
    public Movie getMovie(Integer movieId) {
        return moviesRepository.findById(movieId).orElseThrow(MovieNotFoundException::new);
    }

    @Override
    public void addActorToMovie(Integer movieId, Integer actorId) {
        Movie movie = moviesRepository.getById(movieId);
        Actor actor = actorsRepository.getById(actorId);
        Set<Actor> actors = movie.getActors();
        actors.add(actor);
        movie.setActors(actors);
        moviesRepository.save(movie);
    }

    @Override
    public void update(Integer movieId, MovieForm movieForm) {
        Movie movie = moviesRepository.getById(movieId);
        movie.setTitle(movieForm.getTitle());
        movie.setReleaseDate(LocalDate.parse(movieForm.getReleaseDate()));
        movie.setGenre(movieForm.getGenre());
        movie.setMediumScore(movieForm.getMediumScore());
        moviesRepository.save(movie);
    }

    @Override
    public List<Actor> getActorsNotInAMovie(Integer movieId) {
        Movie movie = moviesRepository.getById(movieId);
        List<Actor> actors = actorsRepository.findAll().stream().filter(actor ->
            !movie.getActors().contains(actor)).collect(Collectors.toList());
        return actors;
    }


}
