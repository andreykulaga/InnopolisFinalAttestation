package ru.pcs.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private LocalDate releaseDate;
    private String genre;

    @ManyToMany
    @JoinTable(name="actor_of_movie",
            joinColumns = @JoinColumn (name="movie_id"),
            inverseJoinColumns = @JoinColumn (name="actor_id"))
    private Set<Actor> actors = new HashSet<>();
    private Double mediumScore;

}




