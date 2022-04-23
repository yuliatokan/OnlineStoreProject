package edu.store.controller;

import edu.store.dto.UserDTO;
import edu.store.entity.Product;
import edu.store.entity.ProductSize;
import edu.store.entity.ProductType;
import edu.store.service.ProductService;
import edu.store.service.ProductSizeService;
import edu.store.service.ProductTypeService;
import edu.store.service.UserService;
import edu.store.service.impl.DefaultProductService;
import edu.store.service.impl.DefaultProductSizeService;
import edu.store.service.impl.DefaultProductTypeService;
import edu.store.service.impl.DefaultUserService;
import edu.store.ui.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    ProductSizeService productSizeService;

    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin")
    public String adminView() {
        return Pages.PAGE_ADMIN;
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String addItemView(Model model) {
        model.addAttribute("sizes", productSizeService.getProductSizes());
        model.addAttribute("types", productTypeService.getProductTypes());
        return Pages.PAGE_ADD_ITEM;
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addItem(@RequestParam(name = "name") String name,
                           @RequestParam(name = "price") String price,
                           @RequestParam(name = "description") String desc,
                           @RequestParam("photo") MultipartFile[] files,
                           @RequestParam(name = "sizeCheckBox") List<Long> sizes,
                           @RequestParam(name = "typeRadios") Long type) {
        Integer product_price = Integer.parseInt(price);
        List<ProductSize> productSizes = productSizeService.findProductSizesByIds(sizes);
        ProductType productType = productTypeService.findProductTypeById(type);

        byte[][] photo = new byte[3][0];
        int i = 0;
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    photo[i] = file.getBytes();
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        Product product = new Product(name, product_price, desc, photo, productType, productSizes);
        productService.addProduct(product);

        return Pages.REDIRECT;
    }

    @RequestMapping(value = "/admin/users")
    public String findUsers(String search, Model model) {
        List<UserDTO> users;
        if (search == null) {
            model.addAttribute("users", userService.getUsers());
            return Pages.PAGE_USERS;
        } else {
            users = userService.getUsersByPhone(search);
            if (users.isEmpty()) {
                users = userService.getUsersByName(search);
                if (users.isEmpty()) {
                    users = userService.getUsersByEmail(search);
                }
            }
        }
        model.addAttribute("search", search);
        model.addAttribute("users", users);
        return Pages.PAGE_USERS;
    }

    @RequestMapping(value = "/admin/products")
    public String adminProducts() {
        return Pages.PAGE_ADMIN_PRODUCTS;
    }

}
