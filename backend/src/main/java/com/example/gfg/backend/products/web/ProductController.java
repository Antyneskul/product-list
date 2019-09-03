package com.example.gfg.backend.products.web;

import com.example.gfg.backend.products.data.ProductSearchResults;
import com.example.gfg.backend.products.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        log.debug("getting all entries");
        this.productService = productService;
    }

    @GetMapping
    public ProductSearchResults getAll() {
        return productService.getAllProducts();
    }

    @GetMapping(params = {"search"})
    public ProductSearchResults getBySearchInput(
            @RequestParam("search") String search,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "25") Integer pageSize) {

        if (page <= 0 || pageSize <= 0) {
            log.error("invalid parameter, page:{}, pageSize{}", page, pageSize);
            throw new IllegalArgumentException("Invalid parameters");
        }

        log.info("getting entries by search:{}, page:{}, pageSize{}", search, page, pageSize);
        return productService.searchProducts(search, page, pageSize);
    }
}


