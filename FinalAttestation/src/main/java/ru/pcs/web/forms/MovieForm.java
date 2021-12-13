package ru.pcs.web.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;


@Data
public class MovieForm {
    @NotEmpty
    @Length(max=30)
    private String title;

    @NotEmpty
    @Past
    private String releaseDate;

    @NotEmpty
    @Length(max=10)
    private String genre;

    private Double mediumScore;





}
