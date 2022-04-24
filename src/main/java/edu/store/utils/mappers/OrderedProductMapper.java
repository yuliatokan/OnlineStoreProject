package edu.store.utils.mappers;

import edu.store.dto.OrderedProductDTO;
import edu.store.entity.OrderedProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, ProductSizeMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderedProductMapper {
    OrderedProductDTO map(OrderedProduct orderedProduct);
}
