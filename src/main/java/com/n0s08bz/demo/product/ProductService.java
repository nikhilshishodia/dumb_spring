package com.n0s08bz.demo.product;

import com.n0s08bz.demo.repo.SolrProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SolrProductRepository solrProductRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, SolrProductRepository solrProductRepository) {
        this.productRepository = productRepository;
        this.solrProductRepository = solrProductRepository;
    }

    public void addNewProduct(Product product) {
        Optional<List<Product>> productByName = productRepository.findProductsByName(product.getName());
        if(productByName.isPresent()) {
            throw new IllegalStateException("Product by same name exists");
        }
        productRepository.save(product);
    }

    public Optional<List<Product>> getProduct(String name){
        return productRepository.findProductsByName(name);
    }

    public Optional<List<Product>> getProductSolr(String name){
        return solrProductRepository.findByName(name);
    }
}
