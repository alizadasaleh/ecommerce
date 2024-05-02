package com.ailab.ecommerce.order;

import com.ailab.ecommerce.common.BaseEntity;
import com.ailab.ecommerce.customer.Customer;
import com.ailab.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity<Long> {

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products;

}
