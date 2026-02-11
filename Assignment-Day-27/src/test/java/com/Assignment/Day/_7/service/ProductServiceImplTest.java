package com.Assignment.Day._7.service;


import com.Assignment.Day._7.entity.Product;
import com.Assignment.Day._7.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    ProductRepository repo;

    @InjectMocks
    ProductServiceImpl service;

    @Test
    void create_success_whenValidProduct() {
        Product p = new Product();
        when(repo.save(any())).thenReturn(p);

        Product result = service.create(p);

        assertNotNull(result);
    }

    @Test
    void getAll_success() {
        when(repo.findAll()).thenReturn(List.of(new Product()));

        List<Product> result = service.getAll();

        assertEquals(1, result.size());
    }

    @Test
    void sell_success_whenStockEnough() {
        Product p = new Product();
        p.setStock(10);

        when(repo.findById(1L)).thenReturn(Optional.of(p));
        when(repo.save(any())).thenReturn(p);

        Product result = service.sell(1L, 5);

        assertEquals(5, result.getStock());
    }

    @Test
    void sell_throwException_whenStockNotEnough() {
        Product p = new Product();
        p.setStock(2);

        when(repo.findById(1L)).thenReturn(Optional.of(p));

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.sell(1L, 5));

        assertEquals("Stock tidak cukup", ex.getMessage());
    }

    @Test
    void delete_success() {
        doNothing().when(repo).deleteById(1L);

        service.delete(1L);

        verify(repo).deleteById(1L);
    }
}
