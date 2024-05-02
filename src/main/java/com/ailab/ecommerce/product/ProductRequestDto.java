package com.ailab.ecommerce.product;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequestDto {

    @NotBlank(message = "Invalid Name: Empty name")
    @NotNull(message = "Invalid Name: Name is NULL")
    @Size(min = 1, max = 255, message = "Invalid Name: Must be of 1 - 255 characters")
    private String name;

    @Min(value = 0, message = "Invalid Age: Equals less than zero")
    private Double Price;
}
