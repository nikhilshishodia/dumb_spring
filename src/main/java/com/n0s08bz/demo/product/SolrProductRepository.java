package com.n0s08bz.demo.product;

import com.n0s08bz.demo.product.Product;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import java.util.*;

public interface SolrProductRepository extends SolrCrudRepository<Product, String> {

    @Query("id:*?0* OR name:*?0* OR category:*?0* OR brand:*?0* OR description:*?0*")
    public Optional<List<Product>> findByName(String name);

}