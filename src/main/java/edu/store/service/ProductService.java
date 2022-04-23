package edu.store.service;

import edu.store.dto.ProductDTO;
import edu.store.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    @Transactional
    void addProduct(Product product);

    @Transactional
    List<ProductDTO> getProducts();

    @Transactional
    ProductDTO getProductById(Long id);

    @Transactional
    Product getProduct(Long id);

    @Transactional
    List<ProductDTO> getProducts(Long id);

    @Transactional
    List<ProductDTO> getProducts(String type);

    @Transactional
    List<ProductDTO> getProducts(String type, List<String> sizes);

    @Transactional
    List<ProductDTO> getProductsByPrice(Integer price_from, Integer price_to);

    @Transactional(readOnly = true)
    Long count();

    @Transactional
    List<ProductDTO> getProductsByPageable(Pageable pageable);

    @Transactional
    void deleteProducts(List<Long> products);
}
