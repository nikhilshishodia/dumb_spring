package com.n0s08bz.demo.product;

import com.n0s08bz.demo.repo.SolrProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;

/*@ComponentScan*/
@Configuration
@EnableJpaRepositories(basePackages = "com.n0s08bz.demo.product")
public class ProductConfig {

        @Bean
        CommandLineRunner commandLineRunner(ProductRepository respository, SolrProductRepository solrProductRepository) {
            return args -> {
                Product airpods = new Product("apple_airpods",
                        "/images/airpods",
                        "true wireless bluetooth headphones",
                        "electronics",
                        "apple",
                        "usd",
                        (float) 99.99
                );

                Product sweatshirt = new Product("hoodie",
                        "/images/hoodie",
                        "full sleeve hooded sweatshirt",
                        "clothing",
                        "gant",
                        "usd",
                        (float) 59.99
                );

                respository.saveAll(List.of(airpods, sweatshirt));
                solrProductRepository.saveAll(List.of(airpods, sweatshirt));
            };
        }

}
