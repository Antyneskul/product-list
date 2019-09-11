package com.example.gfg.backend.products.data;

import com.example.gfg.backend.products.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchResults {
    private List<ProductDTO> products;
    private ResultType type;
    private int total;
}
