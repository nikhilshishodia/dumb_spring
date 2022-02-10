package com.n0s08bz.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Optional<List<Product>> getProduct(@RequestParam String name){
        return productService.getProduct(name);
    }

    @GetMapping(value = "/solr")
    public Optional<List<Product>> getProductSolr(@RequestParam String name){
        return productService.getProductSolr(name);
    }

    @PostMapping()
    public void addNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

}
