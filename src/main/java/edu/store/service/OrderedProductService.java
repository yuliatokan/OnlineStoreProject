package edu.store.service;

import edu.store.entity.OrderedProduct;
import org.springframework.transaction.annotation.Transactional;

public interface OrderedProductService {
    @Transactional
    void addOrderedProduct(OrderedProduct product);
}
