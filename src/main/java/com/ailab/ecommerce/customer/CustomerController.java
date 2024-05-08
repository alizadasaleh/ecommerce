package com.ailab.ecommerce.customer;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public void createCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
         customerService.createCustomer(customerRequestDto);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable("id") Long id,@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        customerService.updateCustomer(id, customerRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }



}
