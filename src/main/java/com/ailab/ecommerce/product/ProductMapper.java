package com.ailab.ecommerce.product;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDto toResponseDto(Product product);
    ProductRequestDto toRequestCreateDto(Product product);
    Product toEntity(ProductRequestDto productRequestDto);
}
