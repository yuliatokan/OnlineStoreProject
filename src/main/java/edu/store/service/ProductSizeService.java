package edu.store.service;

import edu.store.dto.ProductSizeDTO;
import edu.store.entity.ProductSize;
import edu.store.repository.ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSizeService {
    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Transactional
    public boolean addProductSize(String name) {
        ProductSize productSize = new ProductSize(name);
        productSizeRepository.save(productSize);
        return true;
    }

    @Transactional
    public List<ProductSizeDTO> getProductSizes(){
        final List<ProductSizeDTO> result = new ArrayList<>();
        List<ProductSize> productSizes = productSizeRepository.findAll();

        productSizes.forEach((x) -> result.add(x.toDTO()));
        return result;
    }

    @Transactional
    public List<ProductSize> findProductSizesByIds(List<Long> ids){
        List<ProductSize> productSizes = productSizeRepository.findAllById(ids);
        return productSizes;
    }

    @Transactional
    public ProductSize findProductById(Long id){
        return productSizeRepository.findById(id).get();
    }

}
