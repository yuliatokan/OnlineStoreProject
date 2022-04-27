package edu.store.utils.mappers;

import edu.store.dto.OrderDTO;
import edu.store.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {OrderedProductMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "userAccount", target = "user")
    OrderDTO map(Order order);
}
