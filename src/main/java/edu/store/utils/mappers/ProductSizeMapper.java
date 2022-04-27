package edu.store.utils.mappers;

import edu.store.dto.ProductSizeDTO;
import edu.store.entity.ProductSize;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductSizeMapper {
    ProductSizeDTO map(ProductSize productSize);
}
