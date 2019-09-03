package com.example.gfg.backend.products;

import com.example.gfg.backend.products.data.Product;
import com.example.gfg.backend.products.repository.ProductRepository;
import com.example.gfg.backend.products.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    @Autowired
    ProductService productService;
    private ProductRepository mockedProductRepository;

    @Before
    public void setUp() {
        mockedProductRepository = mock(ProductRepository.class);
        productService = new ProductService(mockedProductRepository);
        ReflectionTestUtils.setField(productService, "repository", mockedProductRepository);
    }

    @Test
    public void getAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();

        product.setBrand("levis");
        product.setTitle("jeans");
        product.setImageUrl("");
        product.setPrice("$10");

        products.add(product);

        when(mockedProductRepository.findAll()).thenReturn(products);
        Assert.assertEquals(productService.getAllProducts().getProducts(), products);
    }

    @Test
    public void searchProductsReturnsMostRated() {
        List<Product> products = new ArrayList<>();
        when(mockedProductRepository.findBySearchInput(anyString(), anyInt(), anyInt())).thenReturn(products);
        when(mockedProductRepository.findMostRated(anyInt())).thenReturn(products);

        productService.searchProducts("Levis", 1, 20);

        verify(mockedProductRepository, times(1)).findBySearchInput("+Levis", 20, 20);
        verify(mockedProductRepository, times(1)).findBySearchInput("Levis", 20, 20);
        verify(mockedProductRepository, times(1)).findMostRated(20);
    }
}
