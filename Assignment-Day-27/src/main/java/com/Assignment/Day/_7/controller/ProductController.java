package com.Assignment.Day._7.controller;

import com.Assignment.Day._7.dto.ApiResponse;   // ← INI WAJIB
import com.Assignment.Day._7.entity.Product;
import com.Assignment.Day._7.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<?> create(@RequestBody Product p) {
        return new ApiResponse<>(true, "Produk berhasil ditambahkan", service.create(p));
    }

    @GetMapping
    public ApiResponse<?> getAll() {
        return new ApiResponse<>(true, "Berhasil ambil data", service.getAll());
    }

    @PostMapping("/{id}/sell")
    public ApiResponse<?> sell(@PathVariable Long id, @RequestParam int quantity) {
        return new ApiResponse<>(true, "Penjualan berhasil", service.sell(id, quantity));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ApiResponse<>(true, "Produk berhasil dihapus", null);
    }
}
