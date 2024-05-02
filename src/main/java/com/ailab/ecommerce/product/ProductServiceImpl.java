package com.ailab.ecommerce.product;

import com.ailab.ecommerce.exceptions.ProductAlreadyExists;
import com.ailab.ecommerce.exceptions.ProductNotFound;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> Products = productRepository.findAll();
        return Products.stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto getProductById(long id) {
        return productMapper.toResponseDto(productRepository.findById(id).orElseThrow(() -> new ProductNotFound("Product Not Found")));
    }

    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductRequestCreateDto productRequestCreateDto) {
        var existingProduct = productRepository.findByName(productRequestCreateDto.getName());
        if (existingProduct.isPresent()) {
            throw new ProductAlreadyExists("Product with this name already exists");
        }
        return productMapper.toResponseDto(productRepository.save(productMapper.toEntity(productRequestCreateDto)));
    }



    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
