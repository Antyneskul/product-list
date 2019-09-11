package com.example.gfg.backend.products.dto;

import com.example.gfg.backend.products.data.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductDTO toProductDTO(Product product) {
        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setBrand(product.getBrand());
        dto.setPrice(product.getPrice());
        dto.setRating(product.getRating());
        dto.setImageUrl(product.getImageUrl());

        return dto;
    }

    public List<ProductDTO> toProductDTOs(List<Product> products) {
        return products.stream().map(this::toProductDTO).collect(Collectors.toList());
    }

}
