package ru.pcs.web.services;

import ru.pcs.web.forms.ActorForm;
import ru.pcs.web.models.Actor;

import java.util.List;

public interface ActorsService {
    void addActor(ActorForm form);
    List<Actor> getAllActors();
    void deleteActor(Integer actorId);
    Actor getActor(Integer actorId);
    void update(Integer actorId, ActorForm actorForm);
}
