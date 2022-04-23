package edu.store.service;

import edu.store.dto.ProductSizeDTO;
import edu.store.entity.ProductSize;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductSizeService {
    @Transactional
    boolean addProductSize(String name);

    @Transactional
    List<ProductSizeDTO> getProductSizes();

    @Transactional
    List<ProductSize> findProductSizesByIds(List<Long> ids);

    @Transactional
    ProductSize findProductById(Long id);
}
