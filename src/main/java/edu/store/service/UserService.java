package edu.store.service;

import edu.store.dto.UserDTO;
import edu.store.entity.UserAccount;
import edu.store.entity.UserRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional(readOnly = true)
    List<UserAccount> getAllUsers();

    @Transactional(readOnly = true)
    UserAccount findByEmail(String email);

    @Transactional
    boolean addUser(String email, String passHash, String name, String phone, UserRole role);

    @Transactional
    List<UserDTO> getUsers();

    @Transactional
    List<UserDTO> getUsersByPhone(String phone);

    @Transactional
    List<UserDTO> getUsersByName(String name);

    @Transactional
    List<UserDTO> getUsersByEmail(String email);

    @Transactional
    void updateUser(UserDTO userDTO);
}
