package com.ailab.ecommerce.customer;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(long id);

    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);

    void deleteCustomer(long id);

    CustomerResponseDto updateCustomer(Long id, CustomerRequestDto customerRequestDto);

}
