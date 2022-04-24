package edu.store.dto;

import edu.store.entity.Product;
import edu.store.entity.ProductSize;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderedProductDTO {
    private Long id;
    private ProductDTO product;
    private ProductSizeDTO productSize;
    private int quantity;

    public OrderedProductDTO(Long id, ProductDTO product, ProductSizeDTO productSize, int quantity) {
        this.id = id;
        this.product = product;
        this.productSize = productSize;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public ProductSizeDTO getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSizeDTO productSize) {
        this.productSize = productSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
