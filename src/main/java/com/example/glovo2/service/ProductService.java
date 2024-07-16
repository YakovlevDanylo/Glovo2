package com.example.glovo2.service;

import com.example.glovo2.dto.ProductDTO;
import com.example.glovo2.entity.ProductEntity;
import com.example.glovo2.mapper.ProductMapper;
import com.example.glovo2.repository.ProductRepository;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {

        return productRepository.findAll().stream().map(ProductMapper::toDTO).toList();
    }

    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity = ProductMapper.toEntity(productDTO);
        productEntity.setCreateDate(LocalDate.now());
        productEntity = productRepository.save(productEntity);
        productDTO.setId(productEntity.getId());
        return productDTO;
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }

    public ProductDTO getById(int id) {
        return productRepository.findById(id).map(ProductMapper::toDTO).orElseThrow();
    }
}
