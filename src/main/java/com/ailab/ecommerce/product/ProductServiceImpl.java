package com.ailab.ecommerce.product;

import com.ailab.ecommerce.exceptions.EntityNotFoundException;
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
    public ProductResponseDto getProductById(Long id) {
        return productMapper.toResponseDto(productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product Not Found")));
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(Long productId, ProductRequestDto productRequestDto){
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        existingProduct.setName(productRequestDto.getName());
        existingProduct.setPrice(productRequestDto.getPrice());

        Product updatedProduct = productRepository.save(existingProduct);

        return productMapper.toResponseDto(updatedProduct);
    }

    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        return productMapper.toResponseDto(productRepository.save(productMapper.toEntity(productRequestDto)));
    }



    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found to delete"));
        productRepository.delete(product);
    }
}
