package edu.store.entity;

import edu.store.dto.OrderedProductDTO;

import javax.persistence.*;

@Entity
@Table(name = "ordered_product")
public class OrderedProduct {

    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    /*@JoinColumn(name = "customer_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Order order;*/

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    //@JoinColumn(name = "product_size_id", referencedColumnName = "id")
    @JoinColumns({
            @JoinColumn(name = "product_size_id", referencedColumnName = "id")
            //@JoinColumn(name = "product_id", referencedColumnName = "id")

    })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProductSize productSize;

    @Column(name = "quantity")
    private int quantity;

    public OrderedProduct(){}

    public OrderedProduct(Product product, ProductSize productSize, int quantity) {
        this.product = product;
        this.productSize = productSize;
        this.quantity = quantity;
    }

    public OrderedProductDTO toDTO(){
        return OrderedProductDTO.of(id, product, productSize, quantity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }*/

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
