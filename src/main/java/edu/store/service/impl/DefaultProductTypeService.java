package edu.store.service.impl;

import edu.store.dto.ProductTypeDTO;
import edu.store.entity.ProductType;
import edu.store.repository.ProductTypeRepository;
import edu.store.service.ProductTypeService;
import edu.store.utils.mappers.ProductTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultProductTypeService implements ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    private final ProductTypeMapper productTypeMapper;

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
