package com.Assignment.Day._7.service;

import com.Assignment.Day._7.entity.Product;
import com.Assignment.Day._7.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product create(Product p) {
        return repo.save(p);
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product sell(Long id, int quantity) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Produk tidak ditemukan"));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Stock tidak cukup");
        }

        product.setStock(product.getStock() - quantity);
        return repo.save(product);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
