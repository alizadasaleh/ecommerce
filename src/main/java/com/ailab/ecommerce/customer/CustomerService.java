package com.ailab.ecommerce.customer;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(long id);

    void createCustomer(CustomerRequestDto customerRequestDto);

    void deleteCustomer(long id);

    void updateCustomer(Long id, CustomerRequestDto customerRequestDto);

}
