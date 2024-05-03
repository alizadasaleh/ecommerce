package com.ailab.ecommerce.product;

import jakarta.transaction.Transactional;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(Long id);

    @Transactional
    ProductResponseDto updateProduct(Long productId, ProductRequestDto productRequestDto);

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    void deleteProduct(Long id);

}
