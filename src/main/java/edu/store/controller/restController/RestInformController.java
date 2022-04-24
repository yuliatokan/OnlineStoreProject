package edu.store.controller.restController;

import edu.store.dto.ProductTypeDTO;
import edu.store.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestInformController {

    private final ProductTypeService productTypeService;

    @GetMapping(value = "/get/types")
    public List<ProductTypeDTO> getProductTypes() {
        return productTypeService.getProductTypes();
    }
}
