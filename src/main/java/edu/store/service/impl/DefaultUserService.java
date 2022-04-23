package edu.store.service.impl;

import edu.store.dto.UserDTO;
import edu.store.entity.UserAccount;
import edu.store.entity.UserRole;
import edu.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultUserService implements edu.store.service.UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UserAccount findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public boolean addUser(String email, String passHash, String name, String phone, UserRole role) {
        if (userRepository.existsByEmail(email))
            return false;

        UserAccount user = new UserAccount(email, passHash, name, phone, role);
        userRepository.save(user);

        return true;
    }

    @Override
    @Transactional
    public List<UserDTO> getUsers() {
        final List<UserDTO> users = new ArrayList<>();
        List<UserAccount> userAccounts = userRepository.findAll();

        userAccounts.forEach((x) -> users.add(x.toDTO()));
        return users;
    }

    @Override
    @Transactional
    public List<UserDTO> getUsersByPhone(String phone) {
        final List<UserDTO> users = new ArrayList<>();
        List<UserAccount> userAccounts = userRepository.findByPhone(phone);

        userAccounts.forEach((x) -> users.add(x.toDTO()));
        return users;
    }

    @Override
    @Transactional
    public List<UserDTO> getUsersByName(String name) {
        final List<UserDTO> users = new ArrayList<>();
        List<UserAccount> userAccounts = userRepository.findByName(name);

        userAccounts.forEach((x) -> users.add(x.toDTO()));
        return users;
    }

    @Override
    @Transactional
    public List<UserDTO> getUsersByEmail(String email) {
        final List<UserDTO> users = new ArrayList<>();
        UserAccount userAccount = userRepository.findByEmail(email);
        if (userAccount != null) {
            users.add(userAccount.toDTO());
        }
        return users;
    }

    @Override
    @Transactional
    public void updateUser(UserDTO userDTO) {
        UserAccount user = findByEmail(userDTO.getEmail());

        String passHash = passwordEncoder.encodePassword(userDTO.getPassword(), null);

        user.setName(userDTO.getName());
        user.setPassword(passHash);
        user.setPhone(userDTO.getPhone());

        userRepository.save(user);
    }
}
