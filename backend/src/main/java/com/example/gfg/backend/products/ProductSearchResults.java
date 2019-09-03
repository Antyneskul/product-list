package com.example.gfg.backend.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

enum ResultType {
    ALL,
    EXACT,
    RELEVANT,
    MOST_POPULAR
}

@Data
public class ProductSearchResults {
    private List<Product> products;
    private ResultType type;
    private int total;
}
