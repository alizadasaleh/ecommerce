package com.ailab.ecommerce.customer;

import com.ailab.ecommerce.exceptions.CustomerAlreadyExists;
import com.ailab.ecommerce.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDto getCustomerById(long id) {
        return customerMapper.toResponseDto(customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Customer.class,id)));
    }

    @Override
    @Transactional
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        Optional<Customer> existingCustomer = customerRepository.findByEmail(customerRequestDto.getEmail());
        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExists("Customer with the given email already exists.");
        }
        return customerMapper.toResponseDto(customerRepository.save(customerMapper.toEntity(customerRequestDto)));
    }

    @Override
    @Transactional
    public void deleteCustomer(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Customer.class,id));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerResponseDto updateCustomer(Long id, CustomerRequestDto customerRequestDto) {
        var existingCustomer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found with the given ID."));
        existingCustomer.setEmail(customerRequestDto.getEmail());
        existingCustomer.setName(customerRequestDto.getName());
        existingCustomer.setAddress(customerRequestDto.getAddress());
        return customerMapper.toResponseDto(customerRepository.save(existingCustomer));

    }
}
