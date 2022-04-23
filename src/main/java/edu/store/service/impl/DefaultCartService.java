package edu.store.service.impl;

import edu.store.entity.Cart;
import edu.store.repository.CartRepository;
import edu.store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultCartService implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    @Transactional
    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }
}
