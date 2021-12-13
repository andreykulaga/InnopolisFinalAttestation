package ru.pcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.pcs.web.forms.MovieForm;
import ru.pcs.web.models.Movie;
import ru.pcs.web.services.MoviesService;

import javax.validation.Valid;
import java.util.List;

@Controller

public class MoviesController {

    private final MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/movies")
    public String getMoviesPage(Model model) {
        List<Movie> movies = moviesService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/movies/{movie-id}")
    public String getMoviePage(Model model, @PathVariable("movie-id") Integer movieId) {
        Movie movie = moviesService.getMovie(movieId);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("/{movie-id}/add_actor")
    public String addActorPage(Model model, @PathVariable("movie-id") Integer movieId) {
        Movie movie = moviesService.getMovie(movieId);
        model.addAttribute("movie", movie);
        model.addAttribute("actors", moviesService.getActorsNotInAMovie(movieId));
        return "add_actor";
    }

    @PostMapping("/{movie-id}/add_actor/{actor-id}")
    public String addActorToMovie(Model model,
                                  @PathVariable("movie-id") Integer movieId,
                                  @PathVariable("actor-id") Integer actorId) {
        moviesService.addActorToMovie(movieId, actorId);
        return "redirect:/{movie-id}/add_actor";
    }

    @PostMapping("/movies")
    public String addMovie(@Valid MovieForm form, BindingResult result, RedirectAttributes forRedirectModel) {
        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors", "Есть ошибки на форме!");
            return "redirect:/movies";
        }
        moviesService.addMovie(form);
        return "redirect:/movies";
    }

    @PostMapping("/movies/{movie-id}/delete")
    public String deleteMovie(@PathVariable("movie-id") Integer movieId) {
        moviesService.deleteMovie(movieId);
        return "redirect:/movies";
    }

    @PostMapping("/movies/{movie-id}/update")
    public String update(@PathVariable("movie-id") Integer movieId, MovieForm movieForm) {
        moviesService.update(movieId, movieForm);
        return "redirect:/movies";
    }


}
