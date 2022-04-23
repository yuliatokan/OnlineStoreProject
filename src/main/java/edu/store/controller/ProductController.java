package edu.store.controller;

import edu.store.dto.ProductDTO;
import edu.store.service.ProductService;
import edu.store.service.ProductSizeService;
import edu.store.service.ProductTypeService;
import edu.store.ui.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductSizeService productSizeService;

    @RequestMapping(value = "/products")
    public String getProducts(Model model, @RequestParam(name = "size", required = false) List<String> sizes,
                              @RequestParam(name = "from", required = false) Integer price_from,
                              @RequestParam(name = "to", required = false) Integer price_to) {
        if (sizes == null && price_from == null && price_to == null) {
            model.addAttribute("products", productService.getProducts());
        } else if (sizes == null) {
            model.addAttribute("from", price_from);
            model.addAttribute("to", price_to);
            model.addAttribute("products", productService.getProductsByPrice(price_from, price_to));
        } else if (price_from == null && price_to == null) {
            model.addAttribute("check_sizes", sizes);
            model.addAttribute("products", productService.getProducts(null, sizes));
        }
        model.addAttribute("types", productTypeService.getProductTypes());
        model.addAttribute("sizes", productSizeService.getProductSizes());
        return Pages.PAGE_PRODUCTS;
    }

    @RequestMapping(value = "/products/{type}")
    public String getProducts(Model model, @PathVariable String type, @RequestParam(name = "size", required = false) List<String> sizes) {
        if (sizes == null) {
            model.addAttribute("products", productService.getProducts(type));
        } else {
            model.addAttribute("check_sizes", sizes);
            model.addAttribute("products", productService.getProducts(type, sizes));
        }
        model.addAttribute("types", productTypeService.getProductTypes());
        model.addAttribute("sizes", productSizeService.getProductSizes());
        return Pages.PAGE_PRODUCTS;
    }

    @RequestMapping(value = "item/{id}")
    public String getProduct(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return Pages.PAGE_PRODUCT;
    }

    @PostMapping(value = "/search")
    public String search(Model model, @RequestParam(name = "search") String search) {
        model.addAttribute("products", new ArrayList<ProductDTO>());
        if (search.isEmpty()) {
            return Pages.PAGE_WELCOME_PAGE;
        }
        List<ProductDTO> products = productService.getProducts(search);
        if (products.isEmpty()) {
            if (search.matches("[-+]?\\d+")) {
                Long id = Long.parseLong(search);
                products = productService.getProducts(id);
                if (products != null) {
                    model.addAttribute("products", products);
                }
            }
        } else {
            model.addAttribute("products", products);
        }
        model.addAttribute("types", productTypeService.getProductTypes());
        model.addAttribute("sizes", productSizeService.getProductSizes());
        return Pages.PAGE_PRODUCTS;
    }
}
