package edu.store.service;

import edu.store.entity.Cart;
import edu.store.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }
}
