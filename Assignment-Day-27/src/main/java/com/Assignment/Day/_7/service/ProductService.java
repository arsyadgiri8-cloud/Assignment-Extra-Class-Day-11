package com.Assignment.Day._7.service;

import com.Assignment.Day._7.entity.Product;
import com.Assignment.Day._7.exception.InvalidStockException;
import com.Assignment.Day._7.exception.ResourceNotFoundException;
import com.Assignment.Day._7.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;


import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo){
        this.repo = repo;
    }

    public Product create(Product p){
        log.info("Menambah produk {}", p.getName());
        return repo.save(p);
    }

    @Cacheable("products")
    public List<Product> getAll(){
        log.info("Mengambil semua produk");
        return repo.findAll();
    }

    public Product sell(Long id, int qty){
        Product p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Produk tidak ditemukan"));

        if(p.getStock() < qty){
            throw new RuntimeException("Stok tidak cukup");
        }

        p.setStock(p.getStock() - qty);
        return repo.save(p);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

}
