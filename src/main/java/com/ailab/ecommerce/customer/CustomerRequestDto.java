package com.ailab.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRequestDto {

    @NotBlank(message = "Invalid Name: Empty name")
    @NotNull(message = "Invalid Name: Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Invalid Address: Empty address")
    @NotNull(message = "Invalid Address: Address is NULL")
    @Size(min = 3, max = 255, message = "Invalid Address: Must be of 3 - 255 characters")
    private String address;
}
