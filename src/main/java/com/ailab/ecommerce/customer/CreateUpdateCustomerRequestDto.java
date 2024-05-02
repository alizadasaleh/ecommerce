package com.ailab.ecommerce.customer;

import lombok.Data;

@Data
public class CreateUpdateCustomerRequestDto {
    private String name;

    private String email;

    private String address;
}
