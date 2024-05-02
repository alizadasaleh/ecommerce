package com.ailab.ecommerce.product;

import com.ailab.ecommerce.common.BaseEntity;
import com.ailab.ecommerce.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product extends BaseEntity<Long>{

    @Column(length = 255, nullable = true)
    private String name;

    @Column(nullable = false)
    private Double price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

}
