package com.ailab.ecommerce.product;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProduct(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.updateProduct(id, productRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
