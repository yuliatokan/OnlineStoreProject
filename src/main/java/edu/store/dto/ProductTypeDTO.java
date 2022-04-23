package edu.store.dto;

import edu.store.entity.ProductType;

public class ProductTypeDTO {
    Long id;

    String name;

    public ProductTypeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ProductTypeDTO of (Long id, String name){
        return new ProductTypeDTO(id, name);
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
}
