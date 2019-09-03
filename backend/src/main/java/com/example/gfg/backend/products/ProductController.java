package com.example.gfg.backend.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ProductSearchResults getAll() {
        return productService.getAllProducts();
    }

    @GetMapping(params = {"search", "page", "pageSize"})
    public ProductSearchResults getBySearchInput(@RequestParam("search") String search, Integer page, Integer pageSize) {
        return productService.searchProducts(search, page, pageSize);
    }
}


