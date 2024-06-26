package com.ailab.ecommerce.product;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(Long id);

    @Transactional
    void updateProduct(Long productId, ProductRequestDto productRequestDto);

    void createProduct(ProductRequestDto productRequestDto);

    void deleteProduct(Long id);

    List<ProductResponseDto> searchProducts(String name);

    List<ProductResponseDto> fuzzySearchProducts(String name);
}
