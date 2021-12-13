package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Actor;


public interface ActorsRepository extends JpaRepository<Actor, Integer> {
}
