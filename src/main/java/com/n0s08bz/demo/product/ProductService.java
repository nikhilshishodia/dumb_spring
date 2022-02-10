package com.n0s08bz.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {

    private final SolrProductRepository solrProductRepository;

    @Autowired
    public ProductService(SolrProductRepository solrProductRepository) {
        this.solrProductRepository = solrProductRepository;
    }

    public void addNewProduct(Product product) {
        Optional<List<Product>> productByName = solrProductRepository.findByName(product.getName());
        if(productByName.isPresent()) {
            throw new IllegalStateException("Product by same name exists");
        }
        solrProductRepository.save(product);
    }

    public Optional<List<Product>> getProductSolr(String name){
        return solrProductRepository.findByName(name);
    }
}
