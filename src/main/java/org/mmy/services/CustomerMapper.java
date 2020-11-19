package org.mmy.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mmy.dto.CustomerDto;
import org.mmy.models.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "customer.firstName", target = "name")
    @Mapping(source = "customer.lastName", target = "fname")
    CustomerDto toDto(Customer customer);
}