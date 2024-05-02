package com.ailab.ecommerce.product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(long id);

    ProductResponseDto createProduct(ProductRequestCreateDto productRequestCreateDto);

    void deleteProduct(long id);

}
