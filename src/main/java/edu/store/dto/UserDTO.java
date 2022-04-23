package edu.store.dto;

import javax.validation.constraints.*;

public class UserDTO {
    private long userId;

    @NotNull
    @Pattern(regexp="^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]+$")
    private String email;

    @NotNull
    //@Min(6)
    private String password;


    @Size(min = 3, max = 20)
    @NotNull
    @Pattern(regexp="^[\\pL '-]+$")
    private String name;

    @Size(min = 9)
    private String phone;

    public UserDTO(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public static UserDTO of (String email, String password, String name, String phone){
        return new UserDTO(email, password, name, phone);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
