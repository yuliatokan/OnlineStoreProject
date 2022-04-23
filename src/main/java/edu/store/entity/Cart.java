package edu.store.entity;

import org.springframework.web.bind.annotation.SessionAttribute;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @OneToOne
    //@PrimaryKeyJoinColumn
    private UserAccount userAccount;

    @OneToMany(cascade = CascadeType.ALL,
            targetEntity = CartItem.class, mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>(0);

    @Column(name = "products_cost")
    private Integer productsCost;

    public Cart(){}

    public Cart(UserAccount userAccount, List<CartItem> cartItems, Integer productsCost) {
        this.userAccount = userAccount;
        this.cartItems = cartItems;
        this.productsCost = productsCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Integer getProductsCost() {
        return productsCost;
    }

    public void setProductsCost(Integer productsCost) {
        this.productsCost = productsCost;
    }
}
