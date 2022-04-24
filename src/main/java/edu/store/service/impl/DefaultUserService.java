package edu.store.service.impl;

import edu.store.dto.UserDTO;
import edu.store.entity.UserAccount;
import edu.store.entity.UserRole;
import edu.store.repository.UserRepository;
import edu.store.utils.mappers.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements edu.store.service.UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    private UserAccountMapper userAccountMapper;

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
        List<UserAccount> userAccounts = userRepository.findAll();

        return userAccounts.stream().map(userAccountMapper::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<UserDTO> getUsersByPhone(String phone) {
        List<UserAccount> userAccounts = userRepository.findByPhone(phone);

        return userAccounts.stream().map(userAccountMapper::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<UserDTO> getUsersByName(String name) {
        List<UserAccount> userAccounts = userRepository.findByName(name);

        return userAccounts.stream().map(userAccountMapper::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<UserDTO> getUsersByEmail(String email) {
        final List<UserDTO> users = new ArrayList<>();
        UserAccount userAccount = userRepository.findByEmail(email);
        if (userAccount != null) {
            users.add(userAccountMapper.map(userAccount));
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
