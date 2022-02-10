package com.n0s08bz.demo.product;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Random;

@SolrDocument(collection = "product")
public class Product {
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Id
    @Indexed(name = "id", type = "long")
    private Long id;
    @Indexed(name = "name", type = "string")
    private String name;
    @Indexed(name = "image", type = "string")
    private String image;
    @Indexed(name = "description", type = "string")
    private String description;
    @Indexed(name = "category", type = "string")
    private String category;
    @Indexed(name = "brand", type = "string")
    private String brand;
    @Indexed(name = "currency", type = "string")
    private String currency;
    @Indexed(name = "price", type = "float")
    private float price;
    @Indexed(name = "localDateTime", type = "local-datetime")
    private LocalDateTime createdDateTime;
    @Indexed(name = "modifiedDateTime", type = "local-datetime")
    private LocalDateTime modifiedDateTime;

    public Product() {
    }

    public Product(String name, String image, String description, String category, String brand, String currency, float price) {
        Random random = new Random();
        this.id = random.nextLong();
        this.name = name;
        this.image = image;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.currency = currency;
        this.price = price;
        this.createdDateTime = LocalDateTime.now();
        modifiedDateTime = createdDateTime;
    }

    public Product(Long id, String name, String image, String description, String category, String brand, String currency, float price, LocalDateTime createdDateTime, LocalDateTime modifiedDateTime) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.currency = currency;
        this.price = price;
        this.createdDateTime = LocalDateTime.now();
        modifiedDateTime = createdDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public String getCurrency() {
        return currency;
    }

    public float getPrice() {
        return price;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public LocalDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public void setModifiedDateTime(LocalDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", createdDateTime=" + createdDateTime +
                ", modifiedDateTime=" + modifiedDateTime +
                '}';
    }
}
