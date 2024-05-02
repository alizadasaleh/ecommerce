package com.ailab.ecommerce.customer;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(long id);

    CustomerResponseDto createCustomer(CustomerRequestCreateDto customerRequestCreateDto);

    void deleteCustomer(long id);

}
