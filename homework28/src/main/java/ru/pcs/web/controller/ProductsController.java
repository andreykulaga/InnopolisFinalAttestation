package ru.pcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pcs.web.models.Product;
import ru.pcs.web.repositories.ProductRepository;

@Controller

public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public String addProduct(@RequestParam("title") String title,
                             @RequestParam("price") Double price,
                             @RequestParam("amount") Integer amount) {

        Product product = Product.builder()
                .title(title)
                .price(price)
                .amount(amount)
                .build();
        productRepository.save(product);

        return "redirect:products_add.html";
    }
}
