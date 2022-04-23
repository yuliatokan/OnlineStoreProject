package edu.store.entity;

import edu.store.dto.ProductDTO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "photo", nullable = false)
    private byte[][] photo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    /*@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "product_size",
            joinColumns = {
                    @JoinColumn(name = "product_size_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "product_id")})
    private Set<ProductSize> sizes = new HashSet<>();*/

    /*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true,
            targetEntity = ProductSize.class)//, mappedBy = "id")*/
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = ProductSize.class)
    @JoinTable(
            name = "products_sizes",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private List<ProductSize> sizes = new ArrayList<>();

    public Product(){}

    public Product(String name, Integer price, String description, byte[][] photo, ProductType productType, List<ProductSize> sizes) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
        this.productType = productType;
        this.sizes = sizes;
    }

    public ProductDTO toDTO(){
        return ProductDTO.of(id, name, price, description, sizes, photo);
    }

    public List<ProductSize> getSizes() {
        return sizes;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public byte[][] getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
