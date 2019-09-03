package com.example.gfg.backend.products.web;

import com.example.gfg.backend.products.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Test(expected = IllegalArgumentException.class)
    public void getBySearchInput() {
        productController.getBySearchInput("nothing", -1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySearchInput2() {
        productController.getBySearchInput("nothing", 1, -1);
    }
}
