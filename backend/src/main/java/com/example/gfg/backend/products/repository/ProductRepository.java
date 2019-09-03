package com.example.gfg.backend.products.repository;
import com.example.gfg.backend.products.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource(exported = false)
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product " +
            "WHERE match(title) against (?1 in boolean mode) " +
            "group by brand, id " +
            "limit ?2 offset ?3",
            nativeQuery = true)
    List<Product> findBySearchInput(String search, int pageSize, int offset);

    @Query(value = "SELECT COUNT(*) FROM product WHERE match(title) against (?1 in boolean mode)", nativeQuery = true)
    int getTotal(String search);

    @Query(value = "SELECT * from product " +
            "WHERE rating > 4.5 " +
            "order by rating desc " +
            "limit ?1",
            nativeQuery = true)
    List<Product> findMostRated(int pageSize);
}
