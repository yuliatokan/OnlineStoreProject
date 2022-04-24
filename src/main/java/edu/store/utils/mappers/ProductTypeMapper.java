package edu.store.utils.mappers;

import edu.store.dto.ProductTypeDTO;
import edu.store.entity.ProductType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductTypeMapper {
    ProductTypeDTO map(ProductType productType);
}
