package edu.store.dto;

//import com.sun.istack.internal.NotNull;

import edu.store.entity.ProductSize;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long productId;

    //@NotNull
    private String name;

    //@NotNull
    private Integer price;

    private String description;

    private List<ProductSizeDTO> productSizes = new ArrayList<>();

    //@NotNull
    private byte[][] photo;

    public ProductDTO(Long productId, String name, Integer price, String description, List<ProductSizeDTO> sizes, byte[][] photo) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.productSizes = sizes;
        this.photo = photo;
    }

    public static ProductDTO of(Long id, String name, Integer price, String description, List<ProductSize> sizes, byte[][] photo) {
        List<ProductSizeDTO> result = new ArrayList<>();
        sizes.forEach((x) -> result.add(x.toDTO()));
        return new ProductDTO(id, name, price, description, result, photo);
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
