package ru.pcs.web.forms;

import lombok.Data;
import ru.pcs.web.models.User;

import javax.validation.constraints.NotEmpty;


@Data
public class UserForm {

    @NotEmpty
    private User.Role role;
}
