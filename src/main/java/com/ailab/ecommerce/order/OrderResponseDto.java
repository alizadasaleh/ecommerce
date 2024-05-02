package com.ailab.ecommerce.order;

import com.ailab.ecommerce.customer.CustomerResponseDto;
import com.ailab.ecommerce.product.ProductResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {

    private Long id;

    private CustomerResponseDto customer;

    private List<ProductResponseDto> products;
}
