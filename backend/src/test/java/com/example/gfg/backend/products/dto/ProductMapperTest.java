package com.example.gfg.backend.products.dto;

import com.example.gfg.backend.products.data.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductMapperTest {
    private ProductMapper productMapper;
    private Product product;
    private ProductDTO productDTO;


    @Before
    public void setUp() {
        productMapper = new ProductMapper();
        product = new Product();
        productDTO = new ProductDTO();

        product.setTitle("Levis");
        product.setPrice("$100");

        productDTO.setTitle("Levis");
        productDTO.setPrice("$100");
    }


    @Test
    public void toProductDTO() {
        Assert.assertEquals(productMapper.toProductDTO(product), productDTO);
    }

    @Test
    public void toProductDTOs() {
        List<Product> products = new ArrayList();
        List<ProductDTO> productDTOs = new ArrayList();

        products.add(product);
        productDTOs.add(productDTO);

        Assert.assertEquals(productMapper.toProductDTOs(products), productDTOs);
    }
}
