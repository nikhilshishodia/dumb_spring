package com.n0s08bz.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT s FROM Product s WHERE s.name LIKE %?1%")
    Optional<List<Product>> findProductsByName(String name);
}
