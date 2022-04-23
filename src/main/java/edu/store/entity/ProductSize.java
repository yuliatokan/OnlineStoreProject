package edu.store.entity;

import edu.store.dto.ProductSizeDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_size")
public class ProductSize {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "sizes")
    List<Product> products = new ArrayList<>();

    public ProductSize(){}

    public ProductSize(String name) {
        this.name = name;
    }

    public ProductSizeDTO toDTO(){
        return ProductSizeDTO.of(id, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
