package edu.store.controller.restController;

import edu.store.dto.ProductTypeDTO;
import edu.store.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestInformController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping(value = "/get/types")
    public List<ProductTypeDTO> getProductTypes() {
        return productTypeService.getProductTypes();
    }
}
