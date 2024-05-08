package com.ailab.ecommerce.repository;

import com.ailab.ecommerce.order.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;


@Mapper
public interface OrderRepository {
    List<Order> findAllByCustomerId(Long customerId);
    List<Order> findAllByProductsId(Long ProductId);

    void save(Order order);

    void update(Order order);

    Optional<Order> findById(Long orderId);

    void delete(Order order);

    List<Order> findAll();
}
