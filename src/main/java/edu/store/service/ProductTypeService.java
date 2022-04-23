package edu.store.service;

import edu.store.dto.ProductTypeDTO;
import edu.store.entity.ProductType;
import edu.store.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Transactional
    public boolean addProductType(String name) {
        ProductType productType = new ProductType(name);
        productTypeRepository.save(productType);
        return true;
    }

    @Transactional
    public List<ProductTypeDTO> getProductTypes(){
        final List<ProductTypeDTO> result = new ArrayList<>();
        List<ProductType> productTypes = productTypeRepository.findAll();

        productTypes.forEach((x) -> result.add(x.toDTO()));
        return result;
    }

    @Transactional
    public ProductType findProductTypeById(Long id){
        Optional<ProductType> optionalProductType = productTypeRepository.findById(id);
        ProductType productType = optionalProductType.get(); //проверить на не null
        return productType;
    }
}
