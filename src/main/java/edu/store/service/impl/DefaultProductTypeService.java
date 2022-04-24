package edu.store.service.impl;

import edu.store.dto.ProductTypeDTO;
import edu.store.entity.ProductType;
import edu.store.repository.ProductTypeRepository;
import edu.store.utils.mappers.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultProductTypeService implements edu.store.service.ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    @Transactional
    public boolean addProductType(String name) {
        ProductType productType = new ProductType(name);
        productTypeRepository.save(productType);
        return true;
    }

    @Override
    @Transactional
    public List<ProductTypeDTO> getProductTypes() {
        List<ProductType> productTypes = productTypeRepository.findAll();

        return productTypes.stream().map(productTypeMapper::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductType findProductTypeById(Long id) {
        Optional<ProductType> optionalProductType = productTypeRepository.findById(id);
        return optionalProductType.orElse(null);
    }
}
