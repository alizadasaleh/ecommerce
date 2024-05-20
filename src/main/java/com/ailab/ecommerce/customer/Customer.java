package com.ailab.ecommerce.customer;

import com.ailab.ecommerce.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

    private  Long id;

    private String name;

    private String email;

    private String address;

    private List<Order> orders;

}
