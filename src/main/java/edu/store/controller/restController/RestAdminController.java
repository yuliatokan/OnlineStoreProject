package edu.store.controller.restController;

import edu.store.dto.PageCountDTO;
import edu.store.dto.ProductDTO;
import edu.store.dto.ResultDTO;
import edu.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestAdminController {
    private static final int PAGE_SIZE = 5;

    @Autowired
    ProductService productService;

    @GetMapping("count")
    public PageCountDTO count() {
        return PageCountDTO.of(productService.count(), PAGE_SIZE);
    }

    @GetMapping("/admin_products")
    public List<ProductDTO> getAdminProducts(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return productService.getProductsByPageable(
                PageRequest.of(page, PAGE_SIZE, Sort.Direction.DESC, "id")
        );
    }

    @GetMapping("/admin_products_search")
    public ProductDTO search(@RequestParam(name = "search", required = false, defaultValue = "0") String search) {
        Long id = Long.parseLong(search);

        return productService.getProductById(id);
    }

    @PostMapping(value = "/delete_products")
    public ResponseEntity<ResultDTO> delete(@RequestParam(name = "toDelete[]", required = false)
                                                    List<Long> products) {
        if (products != null && products.size() > 0)
            productService.deleteProducts(products);
        return new ResponseEntity<>(new ResultDTO(), HttpStatus.OK);
    }

    @GetMapping("/getImg")
    public byte[] getImg(@RequestParam(name = "id") Long id, @RequestParam(name = "photo") int photo) {
        ProductDTO product = productService.getProductById(id);
        return product.getPhoto()[photo - 1];
    }
}
