package com.ailab.ecommerce.order;


import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Data
public class OrderRequestCreateDto {

    @NotNull(message = "Customer Id cannot be null")
    private Long customerId;

    @NotEmpty(message = "productIds cannot be empty")
    @Size(min = 1, message = "At least one product ID must be provided")
    private List<Long> productIds;

}
