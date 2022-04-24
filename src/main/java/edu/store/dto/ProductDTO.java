package edu.store.dto;

import edu.store.entity.ProductSize;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {
    private Long productId;

    private String name;

    private Integer price;

    private String description;

    private List<ProductSizeDTO> productSizes;

    private byte[][] photo;

    public ProductDTO(Long productId, String name, Integer price, String description, List<ProductSizeDTO> sizes, byte[][] photo) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.productSizes = sizes;
        this.photo = photo;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[][] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[][] photo) {
        this.photo = photo;
    }

    public List<ProductSizeDTO> getSizes() {
        return productSizes;
    }

    public void setSizes(List<ProductSizeDTO> sizes) {
        this.productSizes = sizes;
    }
}
