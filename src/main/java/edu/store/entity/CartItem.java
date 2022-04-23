package edu.store.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cart cart;

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

    CartItem(){}

    public CartItem(Cart cart, Product product, ProductSize productSize, int quantity) {
        this.cart = cart;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

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
