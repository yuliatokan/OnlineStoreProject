package edu.store.service.impl;

import edu.store.dto.ProductDTO;
import edu.store.entity.Product;
import edu.store.entity.ProductSize;
import edu.store.entity.ProductType;
import edu.store.repository.ProductRepository;
import edu.store.repository.ProductSizeRepository;
import edu.store.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultProductService implements edu.store.service.ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductSizeRepository productSizeRepository;

    @Override
    @Transactional
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public List<ProductDTO> getProducts() {
        final List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.findAll();

        products.forEach((x) -> result.add(x.toDTO()));
        return result;
    }

    @Override
    @Transactional
    public ProductDTO getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(Product::toDTO).orElse(null);
    }

    @Override
    @Transactional
    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    @Transactional
    public List<ProductDTO> getProducts(Long id) {
        Optional<Product> product = productRepository.findById(id);
        List<ProductDTO> products = new ArrayList<>();
        if (!product.isPresent())
            return null;
        products.add(product.get().toDTO());
        return products;
    }

    @Override
    @Transactional
    public List<ProductDTO> getProducts(String type) {
        ProductType productType = productTypeRepository.findByName(type);
        final List<ProductDTO> result = new ArrayList<>();
        if (productType != null) {
            List<Product> products = productType.getProducts();

            products.forEach((x) -> result.add(x.toDTO()));
            return result;
        }
        return result;
    }

    @Override
    @Transactional
    public List<ProductDTO> getProducts(String type, List<String> sizes) {
        ProductType productType = productTypeRepository.findByName(type);
        final List<ProductDTO> result = new ArrayList<>();
        List<Product> products;

        if (productType != null) {
            products = productType.getProducts();
        } else {
            products = productRepository.findAll();
        }
        List<Product> products_ok = new ArrayList<>();

        for (Product product : products) {
            for (ProductSize productSize : product.getSizes()) {
                if (sizes.contains(productSize.getName().toLowerCase())) {
                    products_ok.add(product);
                    break;
                }
            }
        }

        products_ok.forEach((x) -> result.add(x.toDTO()));
        return result;
    }

    @Override
    @Transactional
    public List<ProductDTO> getProductsByPrice(Integer price_from, Integer price_to) {
        final List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (product.getPrice().compareTo(price_from) >= 0 && product.getPrice().compareTo(price_to) <= 0) {
                result.add(product.toDTO());
            }
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return productRepository.count();
    }

    @Override
    @Transactional
    public List<ProductDTO> getProductsByPageable(Pageable pageable) {
        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.findAll(pageable).getContent();

        products.forEach((x) -> result.add(x.toDTO()));

        return result;
    }

    @Override
    @Transactional
    public void deleteProducts(List<Long> products) {
        if (products == null || products.isEmpty()) return;
        for (Long id : products) {
            productRepository.deleteProductById(id);
        }
    }

}
