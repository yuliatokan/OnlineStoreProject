package edu.store.dto;

import edu.store.entity.OrderedProduct;
import edu.store.entity.UserAccount;

import java.text.SimpleDateFormat;
import java.util.*;

public class OrderDTO {
    private Long orderId;
    private UserDTO user;
    private Set<OrderedProductDTO> orderedProducts = new HashSet<>(0);
    private Date dateCreated;
    private int productsCost;
    private String status;
    private String phone;
    private String address;
    private String delivery;

    public OrderDTO(Long orderId, UserDTO user, Set<OrderedProductDTO> orderedProducts, Date dateCreated, int productsCost, String status, String phone, String address, String delivery) {
        this.orderId = orderId;
        this.user = user;
        this.orderedProducts = orderedProducts;
        this.dateCreated = dateCreated;
        this.productsCost = productsCost;
        this.status = status;
        this.phone = phone;
        this.address = address;
        this.delivery = delivery;
    }

    public static OrderDTO of(Long id, UserAccount user, Set<OrderedProduct> orderedProducts, int productsCost, Date dateCreated, String status, String phone, String address, String delivery) {
        UserDTO userDTO = null;
        if(user!=null) {
            userDTO = user.toDTO();
        }

        Set<OrderedProductDTO> orderedProductsDTO = new HashSet<>(0);
        orderedProducts.forEach((x) -> orderedProductsDTO.add(x.toDTO()));
        return new OrderDTO(id, userDTO, orderedProductsDTO, dateCreated, productsCost, status, phone, address, delivery);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Set<OrderedProductDTO> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(Set<OrderedProductDTO> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public String getDateCreated() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dateCreated);
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getProductsCost() {
        return productsCost;
    }

    public void setProductsCost(int productsCost) {
        this.productsCost = productsCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
}
