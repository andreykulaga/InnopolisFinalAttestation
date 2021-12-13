package ru.pcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pcs.web.forms.SignUpForm;
import ru.pcs.web.services.SignUpService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/sign_up")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String getSignUpPage() {
        return "/sign_up";
    }

    @PostMapping
    public String signUpUser(SignUpForm form) {
        signUpService.signUpUser(form);
        return "redirect:/sign_in";

    }
}
