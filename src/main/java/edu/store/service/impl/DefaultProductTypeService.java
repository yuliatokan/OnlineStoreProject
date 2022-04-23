package edu.store.service.impl;

import edu.store.dto.ProductTypeDTO;
import edu.store.entity.ProductType;
import edu.store.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultProductTypeService implements edu.store.service.ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

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
        final List<ProductTypeDTO> result = new ArrayList<>();
        List<ProductType> productTypes = productTypeRepository.findAll();

        productTypes.forEach((x) -> result.add(x.toDTO()));
        return result;
    }

    @Override
    @Transactional
    public ProductType findProductTypeById(Long id) {
        Optional<ProductType> optionalProductType = productTypeRepository.findById(id);
        return optionalProductType.orElse(null);
    }
}