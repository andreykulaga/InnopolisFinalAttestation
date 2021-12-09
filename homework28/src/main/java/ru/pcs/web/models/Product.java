package ru.pcs.web.models;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {

    private Integer id;
    private String title;
    private Double price;
    private Integer amount;
}

