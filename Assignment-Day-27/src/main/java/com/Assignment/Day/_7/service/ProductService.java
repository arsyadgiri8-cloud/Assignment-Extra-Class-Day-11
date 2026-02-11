package com.Assignment.Day._7.service;

import com.Assignment.Day._7.entity.Product;
import java.util.List;

public interface ProductService {
    Product create(Product p);

    List<Product> getAll();

    Product sell(Long id, int quantity);

    void delete(Long id);
}
