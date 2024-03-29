package com.example.gfg.backend.products.service;

import com.example.gfg.backend.products.data.Product;
import com.example.gfg.backend.products.data.ProductSearchResults;
import com.example.gfg.backend.products.data.ResultType;
import com.example.gfg.backend.products.dto.ProductDTO;
import com.example.gfg.backend.products.dto.ProductMapper;
import com.example.gfg.backend.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    public ProductSearchResults getAllProducts() {
        List<Product> products = repository.findAll();
        return result(productMapper.toProductDTOs(products), ResultType.ALL, products.size());
    }

    public ProductSearchResults searchProducts(String searchQuery, Integer page, Integer pageSize) {
        String exactSearchQuery = searchQuery.replaceAll("\\b(\\p{L}+)\\b", "+$1");
        List<Product> products;
        int offset = pageSize * page;

        products = repository.findBySearchInput(exactSearchQuery, pageSize, offset);
        if (!products.isEmpty()) {
            int total = repository.getTotal(exactSearchQuery);
            return result(productMapper.toProductDTOs(products), ResultType.EXACT, total);
        }

        products = repository.findBySearchInput(searchQuery, pageSize, offset);
        if (!products.isEmpty()) {
            return result(productMapper.toProductDTOs(products), ResultType.RELEVANT, products.size());
        }
        products = repository.findMostRated(pageSize);
        return result(productMapper.toProductDTOs(products), ResultType.MOST_POPULAR, products.size());
    }

    private ProductSearchResults result(List<ProductDTO> products, ResultType resultType, int total) {
        return new ProductSearchResults(products, resultType, total);
    }

}
