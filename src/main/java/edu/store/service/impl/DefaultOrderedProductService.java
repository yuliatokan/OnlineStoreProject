package edu.store.service.impl;

import edu.store.entity.OrderedProduct;
import edu.store.repository.OrderedProductRepository;
import edu.store.service.OrderedProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultOrderedProductService implements OrderedProductService {

    private final OrderedProductRepository orderedProductRepository;

    @Override
    @Transactional
    public void addOrderedProduct(OrderedProduct product) {
        orderedProductRepository.save(product);
    }
}
