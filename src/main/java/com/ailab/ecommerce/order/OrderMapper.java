package com.ailab.ecommerce.order;


import com.ailab.ecommerce.customer.Customer;
import com.ailab.ecommerce.customer.CustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orders", ignore = true)
    CustomerResponseDto customerToCustomerResponseDto(Customer customer);

    OrderResponseDto toResponseDto(Order order);

}