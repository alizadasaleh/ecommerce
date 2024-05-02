package com.ailab.ecommerce.customer;

import com.ailab.ecommerce.common.BaseEntity;
import com.ailab.ecommerce.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity<Long>{

    @Column(length = 255, nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
