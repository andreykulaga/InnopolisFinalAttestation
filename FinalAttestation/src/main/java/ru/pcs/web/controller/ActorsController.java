package ru.pcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.pcs.web.forms.ActorForm;
import ru.pcs.web.models.Actor;
import ru.pcs.web.services.ActorsService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ActorsController {

    private final ActorsService actorsService;

    @Autowired
    public ActorsController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }
    @GetMapping("/actors")
    public String getActorsPage(Model model) {
        List<Actor> actors = actorsService.getAllActors();
        model.addAttribute("actors", actors);
        return "actors";
    }

    @GetMapping("/actors/{actor-id}")
    public String getActorPage(Model model, @PathVariable("actor-id") Integer actorId) {
        Actor actor = actorsService.getActor(actorId);
        model.addAttribute("actor", actor);
        return "actor";
    }

    @PostMapping("/actors")
    public String addActor(@Valid ActorForm form, BindingResult result, RedirectAttributes forRedirectModel) {
        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors", "Есть ошибки на форме!");
            return "redirect:/actors";
        }
        actorsService.addActor(form);
        return "redirect:/actors";
    }

    @PostMapping("/actors/{actor-id}/delete")
    public String deleteActor(@PathVariable("actor-id") Integer actorId) {
        actorsService.deleteActor(actorId);
        return "redirect:/actors";
    }

    @PostMapping("/actors/{actor-id}/update")
    public String update(@PathVariable("actor-id") Integer actorId, ActorForm actorForm) {
        actorsService.update(actorId, actorForm);
        return "redirect:/actors";
    }

}
