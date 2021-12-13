package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Movie;

public interface MoviesRepository extends JpaRepository<Movie, Integer> {
}
