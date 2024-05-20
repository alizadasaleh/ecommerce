package com.ailab.ecommerce.order;

import com.ailab.ecommerce.common.BaseEntity;
import com.ailab.ecommerce.customer.Customer;
import com.ailab.ecommerce.product.Product;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Getter
@Setter

public class Order {

    private  Long id;

    private Customer customer;

    private List<Product> products;

}
