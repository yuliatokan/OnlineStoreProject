package edu.store.service;

import edu.store.dto.ProductTypeDTO;
import edu.store.entity.ProductType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductTypeService {
    @Transactional
    boolean addProductType(String name);

    @Transactional
    List<ProductTypeDTO> getProductTypes();

    @Transactional
    ProductType findProductTypeById(Long id);
}
