package edu.store.utils.mappers;

import edu.store.dto.UserDTO;
import edu.store.entity.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserAccountMapper {
    @Mapping(source = "id", target = "userId")
    UserDTO map(UserAccount userAccount);
}
