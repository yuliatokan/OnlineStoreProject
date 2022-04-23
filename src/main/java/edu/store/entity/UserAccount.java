package edu.store.entity;

import edu.store.dto.UserDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", length = 11)
    private String phone;

    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private Cart cart;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserAccount() {
    }

    public UserAccount(@Email String email, @Size(min = 6) String password, @Size(min = 3, max = 50) String name, @Size(min = 9) String phone, UserRole role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }

    public static UserAccount of(String email, String password, String name, String phone){
        return new UserAccount(email,password,name,phone,UserRole.USER);
    }

    public static UserAccount fromDTO(UserDTO userDTO){
        return UserAccount.of(userDTO.getEmail(), userDTO.getPassword(), userDTO.getName(), userDTO.getPhone());
    }

    public UserDTO toDTO (){
        return UserDTO.of(email, password, name, phone);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
