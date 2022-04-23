package edu.store.entity;

import edu.store.dto.OrderDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
            targetEntity = OrderedProduct.class)//, mappedBy = "order")
    private Set<OrderedProduct> orderedProducts = new HashSet<>(0);

    @Column(name = "products_cost", nullable = false)
    private int productsCost;

    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "delivery", nullable = false)
    private String delivery;

    public Order() {
    }

    public Order(UserAccount userAccount, Set<OrderedProduct> orderedProducts, Date dateCreated, String status, String phone, String address, String delivery) {
        this.userAccount = userAccount;
        this.orderedProducts = orderedProducts;
        setProductsCost();
        this.dateCreated = dateCreated;
        this.status = status;
        this.phone = phone;
        this.address = address;
        this.delivery = delivery;
    }

    public OrderDTO toDTO(){
        return OrderDTO.of(id, userAccount, orderedProducts, productsCost, dateCreated, status, phone, address, delivery);
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

    public Set<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(Set<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public int getProductsCost() {
        return productsCost;
    }

    public void setProductsCost() {
        int cost = 0;
        for(OrderedProduct orderedProduct: orderedProducts){
            cost+=orderedProduct.getQuantity()*orderedProduct.getProduct().getPrice();
        }
        productsCost = cost;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
