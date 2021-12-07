package ru.pcs.web.repositories;

import ru.pcs.web.models.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void save (Product product);
    List<Product> findAllByPrice(double price);
    List<Product> findAllByOrdersCount(int ordersCount);
}
