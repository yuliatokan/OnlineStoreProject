package edu.store.service.impl;

import edu.store.entity.Cart;
import edu.store.repository.CartRepository;
import edu.store.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultCartService implements CartService {

    private final CartRepository cartRepository;

    @Override
    @Transactional
    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }
}
