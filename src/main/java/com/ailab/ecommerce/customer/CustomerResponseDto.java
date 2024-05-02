package com.ailab.ecommerce.customer;

import com.ailab.ecommerce.order.OrderResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class CustomerResponseDto {

    private Long id;

    private String name;

    private String email;


    private String address;

    private List<OrderResponseDto> orders;
}
