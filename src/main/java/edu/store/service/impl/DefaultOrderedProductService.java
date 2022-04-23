package edu.store.service.impl;

import edu.store.entity.OrderedProduct;
import edu.store.repository.OrderedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultOrderedProductService implements edu.store.service.OrderedProductService {
    @Autowired
    private OrderedProductRepository orderedProductRepository;

    @Override
    @Transactional
    public void addOrderedProduct(OrderedProduct product) {
        orderedProductRepository.save(product);
    }
}
