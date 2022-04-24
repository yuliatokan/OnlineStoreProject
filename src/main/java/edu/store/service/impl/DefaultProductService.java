package edu.store.service.impl;

import edu.store.dto.ProductDTO;
import edu.store.entity.Product;
import edu.store.entity.ProductSize;
import edu.store.entity.ProductType;
import edu.store.repository.ProductRepository;
import edu.store.repository.ProductSizeRepository;
import edu.store.repository.ProductTypeRepository;
import edu.store.service.ProductService;
import edu.store.utils.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultProductService implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductSizeRepository productSizeRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    @Transactional
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(productMapper::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDTO getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(productMapper::map).orElse(null);
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
        products.add(productMapper.map(product.get()));
        return products;
    }

    @Override
    @Transactional
    public List<ProductDTO> getProducts(String type) {
        ProductType productType = productTypeRepository.findByName(type);
        final List<ProductDTO> result = new ArrayList<>();
        if (productType != null) {
            List<Product> products = productType.getProducts();

            products.forEach((x) -> result.add(productMapper.map(x)));
            return result;
        }
        return result;
    }

    @Override
    @Transactional
    public List<ProductDTO> getProducts(String type, List<String> sizes) {
        ProductType productType = productTypeRepository.findByName(type);
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

        return products_ok.stream().map(productMapper::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<ProductDTO> getProductsByPrice(Integer price_from, Integer price_to) {
        final List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (product.getPrice().compareTo(price_from) >= 0 && product.getPrice().compareTo(price_to) <= 0) {
                result.add(productMapper.map(product));
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
        List<Product> products = productRepository.findAll(pageable).getContent();

        return products.stream().map(productMapper::map).collect(Collectors.toList());
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
