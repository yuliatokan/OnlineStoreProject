package edu.store.controller;

import edu.store.dto.UserDTO;
import edu.store.entity.Product;
import edu.store.entity.ProductSize;
import edu.store.entity.ProductType;
import edu.store.service.ProductService;
import edu.store.service.ProductSizeService;
import edu.store.service.ProductTypeService;
import edu.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String add_item_view(Model model) {
        model.addAttribute("sizes", productSizeService.getProductSizes());
        model.addAttribute("types", productTypeService.getProductTypes());
        return "add_item";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String add_item(@RequestParam(name = "name") String name,
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

        return "redirect:/";
    }

    @RequestMapping(value = "/admin/users")
    public String find_users(String search, Model model) {
        List<UserDTO> users = new ArrayList<>();
        if (search == null) {
            model.addAttribute("users", userService.getUsers());
            return "users";
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
        return "users";
    }

    @RequestMapping(value = "/admin/products")
    public String adminProducts() {
        return "admin_products";
    }

}
