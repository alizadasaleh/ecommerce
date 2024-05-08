package com.ailab.ecommerce.repository;

import com.ailab.ecommerce.customer.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CustomerRepository{
    Optional<Customer> findByEmail(String email);

    Optional<Customer> findById(Long id);

    void delete(Customer customer);

    void save(Customer existingCustomer);

    void update(Customer customer);

    List<Customer> findAll();
}
