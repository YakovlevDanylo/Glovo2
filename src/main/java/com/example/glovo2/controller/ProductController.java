package com.example.glovo2.controller;

import com.example.glovo2.dto.ProductDTO;
import com.example.glovo2.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping()
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

}
