package com.example.gfg.backend.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public static final int DEFAULT_PAGE_SIZE = 25;
    public static final int DEFAULT_PAGE = 0;

    public ProductSearchResults getAllProducts() {
        ProductSearchResults searchResults = new ProductSearchResults();

        searchResults.setProducts(repository.findAll());
        searchResults.setType(ResultType.ALL);

        return searchResults;
    }

    public ProductSearchResults searchProducts(String searchQuery, Integer page, Integer pageSize) {
        String exactSearchQuery = searchQuery.replaceAll("\\b(\\p{L}+)\\b", "+$1");
        ResultType resultType = ResultType.EXACT;
        List<Product> products;
        int offset;

        if (page == null) {
            page = DEFAULT_PAGE;
        }

        if (pageSize == null) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        offset = pageSize * page;
        products = repository.findBySearchInput(exactSearchQuery, pageSize, offset);

        if (!products.isEmpty()) {
            int total = repository.getTotal(exactSearchQuery);
            return getSearchResults(products, resultType, total);
        }

        products = repository.findBySearchInput(searchQuery, pageSize, offset);
        resultType = ResultType.RELEVANT;

        if (products.isEmpty()) {
            products = repository.findMostRated(pageSize);
            resultType = ResultType.MOST_POPULAR;
        }

        return getSearchResults(products, resultType, products.size());
    }

    private ProductSearchResults getSearchResults(List<Product> products, ResultType resultType, int total) {
        ProductSearchResults searchResults = new ProductSearchResults();

        searchResults.setProducts(products);
        searchResults.setType(resultType);
        searchResults.setTotal(total);

        return searchResults;
    }

}
