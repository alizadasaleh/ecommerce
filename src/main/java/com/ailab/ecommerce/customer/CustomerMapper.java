package com.ailab.ecommerce.customer;

import com.ailab.ecommerce.order.Order;
import com.ailab.ecommerce.order.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "customer", ignore = true)
    OrderResponseDto orderToOrderResponseDto(Order order);
    CustomerResponseDto toResponseDto(Customer customer);
    Customer toEntity(CustomerRequestDto customerRequestDto);
    List<OrderResponseDto> ordersToOrderResponseDtos(List<Order> orders);


}
