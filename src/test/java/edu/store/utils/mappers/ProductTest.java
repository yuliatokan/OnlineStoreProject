package edu.store.utils.mappers;

import edu.store.dto.ProductDTO;
import edu.store.entity.Product;
import edu.store.entity.ProductSize;
import edu.store.entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

class ProductTest {

    @Autowired
    ProductMapper productMapper;

    
    public void shouldMap() {
        Product product = new Product("Name", 123, "descr", new byte[1][1],
                new ProductType("Name type"), Arrays.asList(new ProductSize("S"), new ProductSize("M")));
        //product.setId(1L);

        ProductDTO productDTO = productMapper.map(product);
        System.out.println(productDTO);
    }
}