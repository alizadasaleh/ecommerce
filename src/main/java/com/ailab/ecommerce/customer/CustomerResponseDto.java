package com.ailab.ecommerce.customer;

import com.ailab.ecommerce.order.OrderResponseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
public class CustomerResponseDto {

    private Long id;

    private String name;

    private String email;


    private String address;

    private List<OrderResponseDto> orders;
}
