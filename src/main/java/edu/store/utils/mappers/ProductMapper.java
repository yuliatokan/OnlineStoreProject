package edu.store.utils.mappers;

import edu.store.dto.ProductDTO;
import edu.store.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {ProductSizeMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    @Mapping(source = "id", target = "productId")
    @Mapping(source = "sizes", target = "productSizes")
    ProductDTO map(Product product);
}
