package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.forms.ActorForm;
import ru.pcs.web.models.Actor;
import ru.pcs.web.repositories.ActorsRepository;
import ru.pcs.web.repositories.MoviesRepository;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ActorsServiceImpl implements ActorsService {

    private final MoviesRepository moviesRepository;
    private final ActorsRepository actorsRepository;

    @Override
    public void addActor(ActorForm form) {
        Actor actor = Actor.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .birthday(LocalDate.parse(form.getBirthday()))
                .build();
        actorsRepository.save(actor);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorsRepository.findAll();
    }

    @Override
    public void deleteActor(Integer actorId) {
        actorsRepository.deleteById(actorId);

    }

    @Override
    public Actor getActor(Integer actorId) {
        return actorsRepository.getById(actorId);
    }

    @Override
    public void update(Integer actorId, ActorForm actorForm) {
        Actor actor = actorsRepository.getById(actorId);
        actor.setFirstName(actorForm.getFirstName());
        actor.setLastName(actorForm.getLastName());
        actor.setBirthday(LocalDate.parse(actorForm.getBirthday()));
        actorsRepository.save(actor);

    }
}
