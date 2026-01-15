package com.Assignment.Day._7.repository;

import com.Assignment.Day._7.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
