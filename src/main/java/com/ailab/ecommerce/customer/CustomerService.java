package com.ailab.ecommerce.customer;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(long id);

    CustomerResponseDto createCustomer(CreateUpdateCustomerRequestDto createUpdateCustomerRequestDto);

    void deleteCustomer(long id);

    CustomerResponseDto updateCustomer(Long id, CreateUpdateCustomerRequestDto createUpdateCustomerRequestDto);

}
