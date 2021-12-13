package ru.pcs.web.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;


@Data
public class ActorForm {
    @NotEmpty
    @Length(max=15)
    private String firstName;

    @NotEmpty
    @Length(max=15)
    private String lastName;

    @NotEmpty
    @Past
    private String birthday;
}
