package com.ailab.ecommerce.order;


import lombok.Data;

import java.util.List;

@Data
public class OrderRequestCreateDto {

    private Long customerId;

    private List<Long> productIds;

}
