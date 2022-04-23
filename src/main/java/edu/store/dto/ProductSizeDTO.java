package edu.store.dto;

public class ProductSizeDTO {
    private Long id;

    private String name;

    public ProductSizeDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ProductSizeDTO of (Long id, String name){
        return new ProductSizeDTO(id, name);
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
