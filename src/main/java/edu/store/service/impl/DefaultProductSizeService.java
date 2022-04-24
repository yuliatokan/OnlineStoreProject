package edu.store.service.impl;

import edu.store.dto.ProductSizeDTO;
import edu.store.entity.ProductSize;
import edu.store.repository.ProductSizeRepository;
import edu.store.utils.mappers.ProductSizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultProductSizeService implements edu.store.service.ProductSizeService {
    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Autowired
    private ProductSizeMapper productSizeMapper;

    @Override
    @Transactional
    public boolean addProductSize(String name) {
        ProductSize productSize = new ProductSize(name);
        productSizeRepository.save(productSize);
        return true;
    }

    @Override
    @Transactional
    public List<ProductSizeDTO> getProductSizes() {
        List<ProductSize> productSizes = productSizeRepository.findAll();

        return productSizes.stream().map(productSizeMapper::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<ProductSize> findProductSizesByIds(List<Long> ids) {
        return productSizeRepository.findAllById(ids);
    }

    @Override
    @Transactional
    public ProductSize findProductById(Long id) {
        return productSizeRepository.findById(id).orElse(null);
    }

}
